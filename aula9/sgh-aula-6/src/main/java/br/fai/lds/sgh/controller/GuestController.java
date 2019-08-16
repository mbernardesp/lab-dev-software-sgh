/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.controller;

import br.fai.lds.sgh.database.dao.IGuestDao;
import br.fai.lds.sgh.database.entity.Guest;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcelo
 */
@RestController
@RequestMapping("api/v1/guest")
@CrossOrigin(origins = "*")
public class GuestController {
    
    @Autowired
    private IGuestDao guestDao;
    
    /**
     * Create guest
     * 
     * @return ResponseEntity
     * @throws java.sql.SQLException
     */
    @PostMapping
    public ResponseEntity<String> create() throws SQLException{
              
        System.out.println(guestDao);
        
        Guest guest = new Guest();
        guest.setAge(73);
        guest.setName("Roberto");
        guest.setPhone("34711432");
        guestDao.create(guest);
        
        return ResponseEntity.ok("create");
    }
    
    /**
     * Read guest by id
     * 
     * @param id Identificator of the guest
     * @return ResponseEntity
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<String> readById(@PathVariable Long id){
        return ResponseEntity.ok("read");
    }

    /**
     * Read all guests 
     * 
     * @return ResponseEntity
     * @throws java.sql.SQLException
     */
    @GetMapping("/read")
    public ResponseEntity<List<Guest>> readAll() throws SQLException{
        
        
        List<Guest> guestlist = guestDao.readAll();
        
        
        return ResponseEntity.ok(guestlist);
    }
    
    /**
     * Update guest by id
     * 
     * @param id Identificator of the guest
     * @return ResponseEntity
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id){
        return ResponseEntity.ok("update");
    }
    
     /**
     * Delete guest by id
     * 
     * @param id Identificator of the guest
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok("delete");
    }
       
}
