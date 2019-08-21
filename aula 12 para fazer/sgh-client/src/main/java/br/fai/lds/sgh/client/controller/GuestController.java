/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller;

import br.fai.lds.sgh.client.pojo.Guest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class GuestController {

    @GetMapping("/guest")
    public String getList(Model model) {

        List<Guest> guestList = new ArrayList<>();
        guestList.add(new Guest(1L, 2L, "Marcelo", 35, "3592033441"));
        guestList.add(new Guest(2L, 3L, "Carina", 30, "3534719500"));

        model.addAttribute("guestList", guestList);

        return "guest/list";
    }

//    @GetMapping("/guest/adicionar")
//    public String getForm(Model model) {
//        return "guest/form";
//    }
}
