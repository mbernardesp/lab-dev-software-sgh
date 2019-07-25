/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.dao;

import br.fai.lds.sgh.database.entity.Guest;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marcelo
 */
public interface IGuestDao {
    
    public void create(Guest guest) throws SQLException;
    public List<Guest> readAll() throws SQLException;
    public Guest readById(long id) throws SQLException;
    public void update(Guest guest) throws SQLException;
    public void delete(Guest guest) throws SQLException;
    
}
