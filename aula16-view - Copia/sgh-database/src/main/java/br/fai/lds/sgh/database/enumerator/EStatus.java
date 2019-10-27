/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.enumerator;

/**
 *
 * @author Marcelo
 */
public enum EStatus {

    CHECKIN("CHECKIN"),
    CHECKOUT("CHECKOUT");

    private String str;

    EStatus(String str) {
        this.str = str;
    }

    public String get() {
        return str;
    }

}
