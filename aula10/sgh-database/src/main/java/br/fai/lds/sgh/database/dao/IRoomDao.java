/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.dao;

import br.fai.lds.sgh.database.entity.Room;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IRoomDao {
    
    public void create(Room room);
    
    public List<Room> readAll();
    
    public List<Room> readByNum(String num);

    public Room readById(Long id);

    public void update(Room room);

    public void delete(Long id);
    
}
