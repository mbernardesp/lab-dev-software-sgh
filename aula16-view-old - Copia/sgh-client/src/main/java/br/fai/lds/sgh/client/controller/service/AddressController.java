/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller.service;

import br.fai.lds.sgh.client.pojo.Address;
import br.fai.lds.sgh.client.pojo.Search;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author marcelo
 */
@Controller
public class AddressController {
    
    @GetMapping("service/address")
    public String address(@ModelAttribute("search") Search search, Model model, HttpSession session) {

        Address address = new Address();

        model.addAttribute("address", address);
        model.addAttribute("search", search);

        return "service/address";
    }

    @PostMapping("service/address")
    public String addressSearch(@ModelAttribute("search") Search search, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        Address address = null;

        try {
            address = restTemplate.getForObject("https://viacep.com.br/ws/" + search.getContent() + "/json/", Address.class);
            System.out.println(address);

        } catch (Exception e) {
        }
        
        model.addAttribute("address", address != null ? address : new Address());
        model.addAttribute("search", search);

        return "service/address";
    }
}
