/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.controller;

import br.fai.lds.sgh.entity.Guest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/guest")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:9090")
public class GuestController {
    
    @PostMapping
    public ResponseEntity create(){

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/read/{id}")
    public ResponseEntity<Guest> readById(@PathVariable("id") Long id){

        //... Aqui usava o map 
        
        Guest guest = new Guest(1L, "Maria", 25, "34712566");
        
        return ResponseEntity.ok(guest);
    }

    @GetMapping("/read")
    public ResponseEntity<List<Guest>> readAll(){
                
        //... Aqui usava o map 

        List<Guest> guestList = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            Guest guest = new Guest(1L, "Guest " + i, 25 + i, "3471256" + i);
            guestList.add(guest);            
        }
        
        return ResponseEntity.ok(guestList);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id") Long id){

        System.out.println("Id updated: " + id);
        
        return ResponseEntity.status(200).build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){

        System.out.println("Id deleted: " + id);
        
        return ResponseEntity.ok().build();
    }
       
}
