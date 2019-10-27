/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh;

import javax.servlet.MultipartConfigElement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

/**
 *
 * @author marcelo
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();

        factory.setMaxFileSize(DataSize.ofBytes(128000000L));
        factory.setMaxRequestSize(DataSize.ofBytes(128000000L));
        return factory.createMultipartConfig();
    }

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
