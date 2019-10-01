/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.validator;

import br.fai.lds.sgh.client.pojo.Login;
import br.fai.lds.sgh.client.service.UserService;
import br.fai.lds.sgh.database.dao.IUserDao;
import br.fai.lds.sgh.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author marcelo
 */
@Component
public class LoginFormValidator implements Validator {

    @Autowired
    IUserDao userDao;
    
    @Autowired
    UserService userService;
    
    @Override
    public boolean supports(Class<?> type) {
        return Login.class.equals(type);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Login login = (Login) target;
        
        User user = null;

        if (login.getUser() == null || login.getUser().isEmpty()) {

            errors.rejectValue("user", "");

        } else if (login.getPass() == null || login.getPass().isEmpty()) {

            errors.rejectValue("pass", "");

        } else {
            
            //Local authentication
            //user = userDao.readByUserNameAndPass(login.getUser(), login.getPass());
            
            //Remote authentication
            user = userService.verifyRemoteUser(login.getUser(), login.getPass());

            if (user == null) {

                errors.rejectValue("msg", "");
            }else{
                
                login.setId(user.getId());                
            }           
        }
    }
}
