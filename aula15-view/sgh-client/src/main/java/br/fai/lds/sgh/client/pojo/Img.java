/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.pojo;

/**
 *
 * @author marcelo
 */
public class Img {
    
    private String filePath;

    public Img() {
    }

    public Img(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Img{" + "filePath=" + filePath + '}';
    }
   
}
