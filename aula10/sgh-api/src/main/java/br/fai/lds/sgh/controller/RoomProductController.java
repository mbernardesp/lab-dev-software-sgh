/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.controller;

import br.fai.lds.sgh.database.dao.IRoomProductDao;
import br.fai.lds.sgh.database.entity.RoomProduct;
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
@RequestMapping("/api/v1/roomProduct")
@CrossOrigin(origins = "*")
public class RoomProductController {

    @Autowired
    IRoomProductDao roomProductDao;

    /**
     * Create roomProduct
     *
     * @param roomProduct
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity create(@RequestBody RoomProduct roomProduct) {

        roomProductDao.create(roomProduct);

        return ResponseEntity.ok().build();
    }

    /**
     * Read roomProduct by id
     *
     * @param idRoom
     * @param idProduct
     * @return ResponseEntity
     */
    @GetMapping("/read/{id}")
    public ResponseEntity readById(@PathVariable("idRoom") long idRoom, @PathVariable("idProduct") long idProduct) {

        RoomProduct roomProduct = roomProductDao.readById(idRoom, idProduct);

        return ResponseEntity.ok(roomProduct);
    }

    /**
     * Read all roomProducts
     *
     * @return ResponseEntity
     */
    @GetMapping("/read")
    public ResponseEntity<List<RoomProduct>> readAll() {

        List<RoomProduct> roomProductList = roomProductDao.readAll();

        return ResponseEntity.ok(roomProductList);
    }

    /**
     * Update roomProduct by id
     *
     * @param roomProduct
     * @return ResponseEntity
     */
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody RoomProduct roomProduct) {

        roomProductDao.update(roomProduct);

        return ResponseEntity.ok().build();
    }

    /**
     * Delete roomProduct by id
     *
     * @param idRoom
     * @param idProduct
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("idRoom") long idRoom, @PathVariable("idProduct") long idProduct) {

        roomProductDao.delete(idRoom, idProduct);

        return ResponseEntity.ok().build();
    }
}
