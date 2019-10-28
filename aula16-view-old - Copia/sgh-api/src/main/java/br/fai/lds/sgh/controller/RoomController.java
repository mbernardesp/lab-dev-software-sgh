/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.controller;

import br.fai.lds.sgh.database.dao.IRoomDao;
import br.fai.lds.sgh.database.entity.Room;
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
@RequestMapping("/api/v1/room")
@CrossOrigin(origins = "*")
public class RoomController {

    @Autowired
    IRoomDao roomDao;

    /**
     * Create room
     *
     * @param room
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity create(@RequestBody Room room) {

        roomDao.create(room);

        return ResponseEntity.ok().build();
    }

    /**
     * Read room by id
     *
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/read/{id}")
    public ResponseEntity readById(@PathVariable("id") Long id) {

        Room room = roomDao.readById(id);

        return ResponseEntity.ok(room);
    }

    /**
     * Read all rooms
     *
     * @return ResponseEntity
     */
    @GetMapping("/read")
    public ResponseEntity<List<Room>> readAll() {

        List<Room> roomList = roomDao.readAll();

        return ResponseEntity.ok(roomList);
    }

    /**
     * Update room by id
     *
     * @param room
     * @return ResponseEntity
     */
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Room room) {

        roomDao.update(room);

        return ResponseEntity.ok().build();
    }

    /**
     * Delete room by id
     *
     * @param id Identifier of the room
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") long id) {

        roomDao.delete(id);

        return ResponseEntity.ok().build();
    }

    /**
     * Read by room num
     *
     * @param num
     * @return ResponseEntity
     */
    @GetMapping("/read/search/{num}")
    public ResponseEntity readByName(@PathVariable("num") String num) {

        List<Room> roomList = roomDao.readByNum(num);

        return ResponseEntity.ok(roomList);
    }
}
