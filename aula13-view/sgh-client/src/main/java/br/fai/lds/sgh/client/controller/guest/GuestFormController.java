/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller.guest;

import br.fai.lds.sgh.client.pojo.Guest;
import br.fai.lds.sgh.client.validator.GuestFormValidator;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class GuestFormController {

    @Autowired
    GuestFormValidator guestValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(guestValidator);
    }
    @GetMapping("/guest/edit")
    public String edit(Model model) {

        Guest guest = new Guest();
        guest.setName("João");

        model.addAttribute("guest", guest);

        return "guest/edit";
    }

    @PostMapping("/guest/save")
    public String save(@ModelAttribute("guest") @Validated Guest guest, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "guest/edit";

        } else {

            return "redirect:/guest/list";
        }
    }
}
