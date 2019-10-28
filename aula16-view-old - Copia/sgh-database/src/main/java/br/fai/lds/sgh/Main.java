/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh;

import br.fai.lds.sgh.database.dao.impl.GuestDao;
import br.fai.lds.sgh.database.entity.Guest;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        GuestDao guestDao = new GuestDao();
        
        //Guest newGuest = new Guest();
        //newGuest.setIdRoom(5);
        //newGuest.setName("Duda");
        //newGuest.setAge(19);
        //newGuest.setPhone("35992458877");
        
        //guestDao.create(newGuest);
        
        List<Guest> guestList = guestDao.readAll();

        for (Guest guest : guestList) {
            System.out.println(guest);
        }
        
        //------------------------------
        
        Guest guest = guestDao.readById(5L);
        guest.setName("Marcelo");        
        guestDao.update(guest);

        Guest guestUpdated = guestDao.readById(guest.getId());
        System.out.println(guestUpdated);

    }
    
}