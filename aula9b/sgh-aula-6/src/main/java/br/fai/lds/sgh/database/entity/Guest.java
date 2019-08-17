/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.entity;

/**
 *
 * @author Marcelo
 */
public class Guest {

    private long id;
    private long idRoom;
    private String name;
    private int age;
    private String phone;

    public Guest() {
    }

    public Guest(long id, long idRoom, String name, int age, String phone) {
        this.id = id;
        this.idRoom = idRoom;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Guest{" + "id=" + id + ", idRoom=" + idRoom + ", name=" + name + ", age=" + age + ", phone=" + phone + '}';
    }

}
