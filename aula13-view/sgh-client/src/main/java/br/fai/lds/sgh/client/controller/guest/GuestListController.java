/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller.guest;

import br.fai.lds.sgh.client.pojo.Guest;
import br.fai.lds.sgh.client.pojo.Search;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class GuestListController {
  
    @GetMapping("guest/list")
    public String getListSearch(@ModelAttribute("search") Search search, Model model) {
        
        List<Guest> guestList = new ArrayList<>();
        guestList.add(new Guest(1L, 2L, "Marcelo", 35, "3592033441"));
        guestList.add(new Guest(2L, 3L, "Carina", 30, "3534719500"));

        model.addAttribute("guestList", guestList);
        model.addAttribute("search", search);

        return "guest/list";
    }  

    @PostMapping("guest/list")
    public String search(@ModelAttribute("search") Search search, Model model) {
        
        List<Guest> guestList = new ArrayList<>();
        guestList.add(new Guest(1L, 2L, "Fernando", 35, "3592033441"));
        guestList.add(new Guest(2L, 3L, "Rita", 30, "3534719500"));

        model.addAttribute("guestList", guestList);
        model.addAttribute("search", search);

        return "guest/list";
    }  
    


    @PostMapping("/guest/delete/{id}")
    public String delete(@PathVariable Long id) {

        return "guest/list";
    }

}
