/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller.login;

import br.fai.lds.sgh.client.pojo.Login;
import br.fai.lds.sgh.client.validator.LoginFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import br.fai.lds.sgh.database.dao.IUserDao;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marcelo
 */
@Controller
public class LoginFormController {

    @Autowired
    LoginFormValidator loginFormValidator;

    @Autowired
    IUserDao userDao;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(loginFormValidator);
    }

    @PostMapping("/login/verify")
    public String verify(@ModelAttribute("login") @Validated Login login, BindingResult result, Model model, HttpSession session) {
        
        if (result.hasErrors()) {

            return "login/login";

        } else {
            
            session.setAttribute("id", login.getId());
            session.setAttribute("user", login.getUser());
            
            model.addAttribute("msg", "SGH Dashboard");
            
            return "dashboard";
        }
    }

}
