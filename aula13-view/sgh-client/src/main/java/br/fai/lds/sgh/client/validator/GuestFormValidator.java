/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.validator;

import br.fai.lds.sgh.database.entity.Guest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author marcelo
 */
@Component
public class GuestFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Guest.class.equals(type);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Guest guest = (Guest) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "");

        if (guest.getAge() == null || guest.getAge() <= 0) {
            errors.rejectValue("age", "");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "");


    }

}
