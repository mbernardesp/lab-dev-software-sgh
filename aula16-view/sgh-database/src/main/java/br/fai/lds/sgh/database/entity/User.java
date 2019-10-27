/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.entity;

import br.fai.lds.sgh.database.enumerator.ELevel;

/**
 *
 * @author Marcelo
 */
public class User {
    
    private Long id;
    private String user;
    private String pass;
    private String name;
    private String email;
    private ELevel level;

    public User() {
    }

    public User(Long id, String user, String pass, String name, String email, ELevel level) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.name = name;
        this.email = email;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ELevel getLevel() {
        return level;
    }

    public void setLevel(ELevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Auth{" + "id=" + id + ", user=" + user + ", pass=" + pass + ", name=" + name + ", email=" + email + ", level=" + level + '}';
    }
}
