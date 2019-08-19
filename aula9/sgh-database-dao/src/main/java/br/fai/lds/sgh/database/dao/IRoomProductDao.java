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
    
    public void create(Room guest);
    
    public List<Room> readAll();

    public Room readById(long id);

    public void update(Room guest);

    public void delete(Room guest);
    
}
