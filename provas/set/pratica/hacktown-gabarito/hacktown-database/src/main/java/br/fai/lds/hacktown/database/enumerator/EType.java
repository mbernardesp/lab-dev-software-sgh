/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.hacktown.database.enumerator;

/**
 *
 * @author Marcelo
 */
public enum EType {

    LECTURE("LECTURE"),
    WORKSHOP("WORKSHOP"),
    BRAINSTORM("BRAINSTORM");

    private String str;

    EType(String str) {
        this.str = str;
    }

    public String get() {
        return str;
    }

}
