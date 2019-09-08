/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.hacktown.database.entity;

import br.fai.lds.hacktown.database.enumerator.EType;
import java.sql.Timestamp;

/**
 *
 * @author Marcelo
 */
public class Schedule {

    private Long id;
    private EType type;
    private String theme;
    private String speaker;
    private String place;
    private Timestamp dateTime;

    public Schedule() {
    }

    public Schedule(Long id, EType type, String theme, String speaker, String place, Timestamp dateTime) {
        this.id = id;
        this.type = type;
        this.theme = theme;
        this.speaker = speaker;
        this.place = place;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Schedule{" + "id=" + id + ", type=" + type + ", theme=" + theme + ", speaker=" + speaker + ", place=" + place + ", dateTime=" + dateTime + '}';
    }
}
