/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.dao;

import br.fai.lds.sgh.database.entity.RoomProduct;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IRoomProductDao {
    
    public void create(RoomProduct roomProduct);
    
    public List<RoomProduct> readAll();

    public RoomProduct readById(long idRoom, long idProduct);

    public void update(RoomProduct roomProduct);

    public void delete(long idRoom, long idProduct);
    
}
