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
public class RoomProduct {
    
    private Long id_room;
    private Long id_product;
    private Integer amount;

    public RoomProduct() {
    }

    public RoomProduct(Long id_room, Long id_product, Integer amount) {
        this.id_room = id_room;
        this.id_product = id_product;
        this.amount = amount;
    }

    public Long getId_room() {
        return id_room;
    }

    public void setId_room(Long id_room) {
        this.id_room = id_room;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RoomProduct{" + "id_room=" + id_room + ", id_product=" + id_product + ", amount=" + amount + '}';
    }
}
