/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Marcelo
 */
public class Address {

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("logradouro")
    private String place;

    @JsonProperty("complemento")
    private String complement;

    @JsonProperty("bairro")
    private String neighborhood;

    @JsonProperty("localidade")
    private String locality;

    @JsonProperty("uf")
    private String state;

    @JsonProperty("unidade")
    private String unit;

    @JsonProperty("ibge")
    private String ibge;

    @JsonProperty("gia")
    private String gia;
    
    public Address() {
    }

    public Address(String cep, String place, String complement, String neighborhood, String locality, String state, String unit, String ibge, String gia) {
        this.cep = cep;
        this.place = place;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.locality = locality;
        this.state = state;
        this.unit = unit;
        this.ibge = ibge;
        this.gia = gia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Address{" + "cep=" + cep + ", place=" + place + ", complement=" + complement + ", neighborhood=" + neighborhood + ", locality=" + locality + ", state=" + state + ", unit=" + unit + ", ibge=" + ibge + ", gia=" + gia + '}';
    }
}
