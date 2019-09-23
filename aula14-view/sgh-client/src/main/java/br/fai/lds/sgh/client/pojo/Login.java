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
    
    private String user;
    private String pass;
    private String msg = "";
    
    public Login() {
    }

    public Login(String user, String pass, String msg) {
        this.user = user;
        this.pass = pass;
        this.msg = msg;
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
        return "Login{" + "user=" + user + ", pass=" + pass + ", msg=" + msg + '}';
    }
}
