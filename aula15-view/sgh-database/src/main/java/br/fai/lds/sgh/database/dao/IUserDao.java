/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.dao;

import br.fai.lds.sgh.database.entity.User;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IUserDao {
    
    public void create(User user);
    
    public List<User> readAll();

    public List<User> readByName(String name);

    public User readById(Long id);
    
    public User readByUserName(String userName);

    public User readByUserNameAndPass(String userName, String pass);

    public void update(User user);

    public void delete(Long id);
}
