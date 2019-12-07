/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.hacktown.database.dao;

import br.fai.lds.hacktown.database.entity.Schedule;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IScheduleDao {
    
    public void create(Schedule schedule);
    
    public List<Schedule> readAll();
    
    public Schedule readById(Long id);

    public void update(Schedule schedule);

    public void delete(Long id);
}
