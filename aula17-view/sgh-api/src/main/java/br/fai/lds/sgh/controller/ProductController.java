/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.controller;

import br.fai.lds.sgh.database.dao.IProductDao;
import br.fai.lds.sgh.database.entity.Product;
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
@RequestMapping("/api/v1/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    IProductDao productDao;

    /**
     * Create product
     *
     * @param product
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity create(@RequestBody Product product) {

        productDao.create(product);

        return ResponseEntity.ok().build();
    }

    /**
     * Read product by id
     *
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/read/{id}")
    public ResponseEntity readById(@PathVariable("id") Long id) {

        Product product = productDao.readById(id);

        return ResponseEntity.ok(product);
    }

    /**
     * Read all products
     *
     * @return ResponseEntity
     */
    @GetMapping("/read")
    public ResponseEntity<List<Product>> readAll() {

        List<Product> productList = productDao.readAll();

        return ResponseEntity.ok(productList);
    }

    /**
     * Update product by id
     *
     * @param product
     * @return ResponseEntity
     */
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Product product) {

        productDao.update(product);

        return ResponseEntity.ok().build();
    }

    /**
     * Delete product by id
     *
     * @param id Identifier of the room
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") long id) {

        productDao.delete(id);

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

        List<Product> productList = productDao.readByName(name);

        return ResponseEntity.ok(productList);
    }
}
