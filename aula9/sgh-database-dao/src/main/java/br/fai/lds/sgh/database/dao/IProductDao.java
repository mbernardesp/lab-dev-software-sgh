/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.dao;

import br.fai.lds.sgh.database.entity.Product;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IProductDao {
    
    public void create(Product product);
    
    public List<Product> readAll();

    public Product readById(long id);

    public void update(Product product);

    public void delete(Product product);
    
}
