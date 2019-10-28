/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.service;

import br.fai.lds.sgh.database.entity.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author marcelo
 */
@Service
public class UserService {

    public User verifyRemoteUser(String userName, String userPass) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User> response = null;
        
        try {
            
            HttpHeaders headers = new HttpHeaders();
            headers.set("user", userName);
            headers.set("pass", userPass);
            
            HttpEntity entity = new HttpEntity("paramters", headers);
            
            response = restTemplate.exchange("http://localhost:9005/sgh/api/v1/user/verify", HttpMethod.GET, entity, User.class);
            
            System.out.println(response.getBody());
            

        } catch (Exception e) {
        }

        return response != null ? response.getBody() : null;
    }
}
