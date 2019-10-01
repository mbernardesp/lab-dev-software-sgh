/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.entity;

import br.fai.lds.sgh.database.enumerator.EStatus;
import br.fai.lds.sgh.database.enumerator.EType;
import java.sql.Timestamp;

/**
 *
 * @author Marcelo
 */
public class Room {
    
    private Long id;
    private String num;
    private EType type;
    private EStatus status;
    private Timestamp dateCheckIn;
    private Timestamp dateCheckOut;

    public Room() {
    }
        
    public Room(Long id, String num, EType type, EStatus status, Timestamp dateCheckIn, Timestamp dateCheckOut) {
        this.id = id;
        this.num = num;
        this.type = type;
        this.status = status;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public Timestamp getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(Timestamp dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public Timestamp getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(Timestamp dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", num=" + num + ", type=" + type + ", status=" + status + ", dateCheckIn=" + dateCheckIn + ", dateCheckOut=" + dateCheckOut + '}';
    }
   
}