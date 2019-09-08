/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.hacktown.controller;

import br.fai.lds.hacktown.database.dao.IScheduleDao;
import br.fai.lds.hacktown.database.entity.Schedule;
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
@RequestMapping("/api/v1/schedule")
@CrossOrigin(origins = "*")
public class ScheduleController {

    @Autowired
    IScheduleDao scheduleDao;

    /**
     * Create schedule
     *
     * @param schedule
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity create(@RequestBody Schedule schedule) {

        scheduleDao.create(schedule);

        return ResponseEntity.ok().build();
    }

    /**
     * Read schedule by id
     *
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/read/{id}")
    public ResponseEntity readById(@PathVariable("id") Long id) {

        Schedule schedule = scheduleDao.readById(id);

        return ResponseEntity.ok(schedule);
    }

    /**
     * Read all schedules
     *
     * @return ResponseEntity
     */
    @GetMapping("/read")
    public ResponseEntity<List<Schedule>> readAll() {

        List<Schedule> schedulesList = scheduleDao.readAll();

        return ResponseEntity.ok(schedulesList);
    }

    /**
     * Update schedule by id
     *
     * @param schedule
     * @return ResponseEntity
     */
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Schedule schedule) {

        scheduleDao.update(schedule);

        return ResponseEntity.ok().build();
    }

    /**
     * Delete schedule by id
     *
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

        scheduleDao.delete(id);

        return ResponseEntity.ok().build();
    }
}
