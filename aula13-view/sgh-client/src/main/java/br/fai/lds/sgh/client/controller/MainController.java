/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class MainController {


    @GetMapping("/")
    public String index(Model model) {

        String msg = "SGH - Sistema gerenciador hoteleiro";

        model.addAttribute("msg", msg);

        return "index";
    }

}
