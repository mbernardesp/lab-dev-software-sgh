/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.controller;

import br.fai.lds.sgh.database.dao.IGuestDao;
import br.fai.lds.sgh.database.dao.IUserDao;
import br.fai.lds.sgh.database.entity.User;
import br.fai.lds.sgh.pojo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcelo
 */
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    IUserDao userDao;

    /**
     * Read guest by id
     *
     * @param login User and pass info
     * @return ResponseEntity
     */
    @GetMapping("/verify")
    public ResponseEntity getVerify(@RequestHeader(value="user") String userName, @RequestHeader(value="pass") String userPass) {
        
        User user = userDao.readByUserNameAndPass(userName, userPass);

        if (user != null) {
     
            return ResponseEntity.ok(user);
        } else {
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
    }

}
