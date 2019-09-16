/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

//        RestTemplate restTemplate = new RestTemplate();
//        Guest guest = null;
//
//        //Read
//        try {
//            guest = restTemplate.getForObject("http://192.168.8.128:9005/sgh/api/v1/guest/read/1", Guest.class);
//            System.out.println(guest);
//
//        } catch (Exception e) {
//        }
//
//        //Update
//        try {
//            guest.setName("Marcelo Bernardes Pinto");
//            restTemplate.put("http://192.168.8.128:9005/sgh/api/v1/guest/update", guest);
//
//        } catch (Exception e) {
//        }
    }
}
