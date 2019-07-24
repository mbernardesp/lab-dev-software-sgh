/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.controller;

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
public class Guest {
    
    @PostMapping
    public ResponseEntity<String> create(){
        return ResponseEntity.ok("create");
    }
    
    @GetMapping("/read/{id}")
    public ResponseEntity<String> readById(@PathVariable String id){
        return ResponseEntity.ok("read");
    }

    @GetMapping("/read")
    public ResponseEntity<String> readAll(){
        return ResponseEntity.ok("read all");
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id){
        return ResponseEntity.ok("update");
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        return ResponseEntity.ok("delete");
    }
       
}
