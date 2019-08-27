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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class GuestController {

    @GetMapping("guest/list")
    public String getList(Model model) {

        List<Guest> guestList = new ArrayList<>();
        guestList.add(new Guest(1L, 2L, "Marcelo", 35, "3592033441"));
        guestList.add(new Guest(2L, 3L, "Carina", 30, "3534719500"));

        model.addAttribute("guestList", guestList);
        
        System.out.println("PASSO 1");

        return "guest/list";
    }

    @GetMapping("/guest/edit")
    public String edit(Model model) {
        
        Guest guest = new Guest();
        guest.setName("João");
        
        model.addAttribute("guest", guest);

//        List<Guest> guestList = new ArrayList<>();
//        guestList.add(new Guest(1L, 2L, "Marcelo", 35, "3592033441"));
//        guestList.add(new Guest(2L, 3L, "Carina", 30, "3534719500"));

        System.out.println("PASSO 2");

        return "guest/edit";
    }

    @PostMapping("/guest/save")
    public String save(@ModelAttribute("guest") Guest guest, BindingResult result, Model model) {

        
        System.out.println(guest);
        
        
//        List<Guest> guestList = new ArrayList<>();
//        guestList.add(new Guest(1L, 2L, "Marcelo", 35, "3592033441"));
//        guestList.add(new Guest(2L, 3L, "Carina", 30, "3534719500"));

        System.out.println("PASSO 3");
        


        //Depois de salvar volta para lista de cadastro
        return "redirect:/guest/list";
    }

    @PostMapping("/guest/delete/{id}")
    public String delete(@PathVariable Long id) {

//        List<Guest> guestList = new ArrayList<>();
//        guestList.add(new Guest(1L, 2L, "Marcelo", 35, "3592033441"));
//        guestList.add(new Guest(2L, 3L, "Carina", 30, "3534719500"));

        //Depois de salvar volta para lista de cadastro

                System.out.println("PASSO 4");


        return "guest/list";
    }
    
}