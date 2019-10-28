/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.controller;

import br.fai.lds.sgh.database.dao.IGuestDao;
import br.fai.lds.sgh.database.entity.Guest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcelo
 */
@RestController
@RequestMapping("/api/v1/guest")
@CrossOrigin(origins = "*")
public class GuestController {

    @Autowired
    IGuestDao guestDao;

    /**
     * Create guest
     *
     * @param guest
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity create(@RequestBody Guest guest) {

        guestDao.create(guest);

        return ResponseEntity.ok().build();
    }

    /**
     * Read guest by id
     *
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/read/{id}")
    public ResponseEntity readById(@PathVariable("id") Long id) {

        Guest guest = guestDao.readById(id);

        return ResponseEntity.ok(guest);
    }

    /**
     * Read all guests
     *
     * @return ResponseEntity
     */
    @GetMapping("/read")
    public ResponseEntity<List<Guest>> readAll() {

        List<Guest> guestList = guestDao.readAll();

        return ResponseEntity.ok(guestList);
    }

    /**
     * Update guest by id
     *
     * @param guest
     * @return ResponseEntity
     */
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Guest guest) {

        guestDao.update(guest);

        return ResponseEntity.ok().build();
    }

    /**
     * Delete guest by id
     *
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

        guestDao.delete(id);

        return ResponseEntity.ok().build();
    }
    
    /**
     * Read by guest name
     *
     * @param name
     * @return ResponseEntity
     */
    @GetMapping("/read/search/{name}")
    public ResponseEntity readByName(@PathVariable("name") String name) {

        List<Guest> guestList = guestDao.readByName(name);

        return ResponseEntity.ok(guestList);
    }
}
