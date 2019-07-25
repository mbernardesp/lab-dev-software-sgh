/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database;

import br.fai.lds.sgh.database.dao.IGuestDao;
import br.fai.lds.sgh.database.entity.Guest;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author marcelo
 */
public class Test {
    
    @Autowired
    private IGuestDao guestDao;

    public Test() {
    
        try {
            Guest guest = guestDao.readById(5L);
            
            System.out.println(guest.getName());
            
        } catch (SQLException ex) {
        }
    
    }
    
    
       

    
}
