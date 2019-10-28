/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller.guest;

import br.fai.lds.sgh.client.pojo.Search;
import br.fai.lds.sgh.database.dao.IGuestDao;
import br.fai.lds.sgh.database.entity.Guest;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    IGuestDao guestDao;

    @GetMapping("guest/list")
    public String getListSearch(@ModelAttribute("search") Search search, Model model) {

        List<Guest> guestList = guestDao.readAll();

        model.addAttribute("guestList", guestList != null ? guestList : Collections.EMPTY_LIST);
        model.addAttribute("search", search);

        return "guest/list";
    }

    @PostMapping("guest/list")
    public String search(@ModelAttribute("search") Search search, Model model) {

        List<Guest> guestList = guestDao.readByName(search.getContent());

        model.addAttribute("guestList", guestList != null ? guestList : Collections.EMPTY_LIST);
        model.addAttribute("search", search);

        return "guest/list";
    }

    @GetMapping("/guest/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {

        Guest guest = guestDao.readById(id);
  
        model.addAttribute("guest", guest);

        return "guest/edit";
    }

    @GetMapping("/guest/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {

        guestDao.delete(id);

        return "redirect:/guest/list";
    }

}
