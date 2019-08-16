/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.dao;

import java.util.List;

/**
 *
 * @author Marcelo
 * @param <T>
 */
public interface IGuestDao<T> {
    
    public void create(T t);
    public List<T> readAll();
    public T readById(long id);
    public void update(T t);
    public void delete(T t);
    
}
