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
    
    private long id_room;
    private long id_product;
    private int amount;

    public RoomProduct() {
    }

    public RoomProduct(long id_room, long id_product, int amount) {
        this.id_room = id_room;
        this.id_product = id_product;
        this.amount = amount;
    }

    public long getId_room() {
        return id_room;
    }

    public void setId_room(long id_room) {
        this.id_room = id_room;
    }

    public long getId_product() {
        return id_product;
    }

    public void setId_product(long id_product) {
        this.id_product = id_product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RoomProduct{" + "id_room=" + id_room + ", id_product=" + id_product + ", amount=" + amount + '}';
    }
    
}
