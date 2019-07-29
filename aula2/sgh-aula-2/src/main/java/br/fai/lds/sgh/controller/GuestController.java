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
@RequestMapping("api/v1/guest")
@CrossOrigin(origins = "*")
public class GuestController {

    /**
     * Create guest
     *
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity create() {

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Read guest by id
     *
     * @param id Identifier of the guest
     * @return ResponseEntity
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<Guest> readById(@PathVariable("id") Long id) {

        //... Aqui usava o map 
        Guest guest = new Guest(1L, "Maria", 25, "34712566");

        return ResponseEntity.ok(guest);
    }

    /**
     * Read all guests
     *
     * @return ResponseEntity
     */
    @GetMapping("/read")
    public ResponseEntity<List<Guest>> readAll() {

        //... Aqui usava o map 
        List<Guest> guestList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Guest guest = new Guest(1L, "Guest " + i, 25 + i, "3471256" + i);
            guestList.add(guest);
        }

        //ou
        //guestList = Arrays.asList(new Guest("Marcelo", 25L), new User("Vitor", 50L));
        return ResponseEntity.ok(guestList);
    }

    /**
     * Update guest by id
     *
     * @param id Identifier of the guest
     * @return ResponseEntity
     */
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id") Long id) {

        System.out.println("Id updated: " + id);

        return ResponseEntity.status(200).build();
    }

    /**
     * Delete guest by id
     *
     * @param id Identifier of the guest
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

        System.out.println("Id deleted: " + id);

        return ResponseEntity.ok().build();
    }

    /**
     * Read guest by name
     *
     * @param name Name of the guest
     * @return ResponseEntity
     */
    @GetMapping("read/{name}")
    public Guest readByName(@PathVariable("name") final String name) {

        //...Aqui usava o map
        Guest guest = new Guest(1L, "Maria", 25, "34712566");

        return guest;
    }

}
