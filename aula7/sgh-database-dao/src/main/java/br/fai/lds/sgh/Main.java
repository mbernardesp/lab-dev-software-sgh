/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh;

import br.fai.lds.sgh.database.dao.IGuestDao;
import br.fai.lds.sgh.database.dao.impl.GuestDao;
import br.fai.lds.sgh.database.entity.Guest;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Main {

    public static void main(String[] args) {

        IGuestDao guestDao = new GuestDao();

        Guest newGuest = new Guest();
        newGuest.setIdRoom(2);
        newGuest.setName("Juca2");
        newGuest.setAge(89);
        newGuest.setCpf("01375266588");
        newGuest.setPhone("35992458877");
        
        guestDao.create(newGuest);
        
        List<Guest> guestList = guestDao.readAll();

        for (Guest guest : guestList) {
            System.out.println(guest);
        }
        
        //------------------------------
        
//        Guest guest = guestDao.readById(1);
//        guest.setName("Dona Maria");        
//        guestDao.update(guest);
//
//        Guest guestUpdated = guestDao.readById(guest.getId());
//        System.out.println(guestUpdated);

        guestDao.closeConnection();
    }
    
}