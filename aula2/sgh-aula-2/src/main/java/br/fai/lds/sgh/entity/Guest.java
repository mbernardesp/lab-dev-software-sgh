/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.controller;

import br.fai.lds.sgh.entity.User;
import java.util.Arrays;
import java.util.List;
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
public class Guest {
    
    /**
     * Create guest
     * 
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<String> create(){
               
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
     */
    @GetMapping("/read")
    public ResponseEntity<String> readAll(){
        return ResponseEntity.ok("read all");
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
    
    @GetMapping("users")
    public List<User> listUser(){
        
        return Arrays.asList(new User("Marcelo", 25L), new User("Vitor", 50L));
    }
    
    @GetMapping("user/{userName}")
    public User userByName(@PathVariable("userName") final String userName){
        
        return new User("Marcelo", 25L);
    }
       
}
