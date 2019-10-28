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

    private Long id;
    private Long idRoom;
    private String name;
    private Integer age;
    private String cpf;
    private String phone;

    public Guest() {
    }

    public Guest(Long id, Long idRoom, String name, Integer age, String cpf, String phone) {
        this.id = id;
        this.idRoom = idRoom;
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Guest{" + "id=" + id + ", idRoom=" + idRoom + ", name=" + name + ", age=" + age + ", cpf=" + cpf + ", phone=" + phone + '}';
    }
}
