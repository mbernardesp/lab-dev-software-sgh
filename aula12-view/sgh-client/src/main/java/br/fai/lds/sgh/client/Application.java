/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client;

import br.fai.lds.sgh.client.pojo.Guest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author marcelo
 */
@SpringBootApplication
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        RestTemplate restTemplate = new RestTemplate();
        Guest guest = restTemplate.getForObject("http://localhost:9005/sgh/api/v1/guest/read/1", Guest.class);
        System.out.println(guest);


    }
    
}
