/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.pojo;

/**
 *
 * @author Marcelo
 */
public class Login {
    
    private Long id;
    private String user;
    private String pass;
    private String msg = "";
    
    public Login() {
    }

    public Login(Long id, String user, String pass) {
        this.id = id;
        this.user = user;
        this.pass = pass;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", user=" + user + ", pass=" + pass + ", msg=" + msg + '}';
    }

}
