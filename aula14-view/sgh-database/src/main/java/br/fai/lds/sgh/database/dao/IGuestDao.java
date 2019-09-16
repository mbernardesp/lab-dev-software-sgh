/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.dao;

import br.fai.lds.sgh.database.entity.Guest;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IGuestDao {
    
    public void create(Guest guest);
    
    public List<Guest> readAll();

    public List<Guest> readByName(String name);

    public Guest readById(Long id);

    public void update(Guest guest);

    public void delete(Long id);
}
