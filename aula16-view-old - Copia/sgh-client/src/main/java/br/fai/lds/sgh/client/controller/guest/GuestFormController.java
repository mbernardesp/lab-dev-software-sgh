/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller.guest;

import br.fai.lds.sgh.client.validator.GuestFormValidator;
import br.fai.lds.sgh.database.dao.IGuestDao;
import br.fai.lds.sgh.database.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class GuestFormController {

    @Autowired
    GuestFormValidator guestValidator;

    @Autowired
    IGuestDao guestDao;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(guestValidator);
    }

    @PostMapping("/guest/save")
    public String save(@ModelAttribute("guest") @Validated Guest guest, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "guest/edit";

        } else {

            guestDao.update(guest);
            
            return "redirect:/guest/list";
        }
    }

}
