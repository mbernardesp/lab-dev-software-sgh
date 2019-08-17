/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marcelo
 * @param <T>
 */
public interface IGuestDao<T> {
    
    public void create(T t) throws SQLException;
    public List<T> readAll() throws SQLException;
    public T readById(long id) throws SQLException;
    public void update(T t) throws SQLException;
    public void delete(T t) throws SQLException;
    
}
