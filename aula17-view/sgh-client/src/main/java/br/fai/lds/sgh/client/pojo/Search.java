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
public class Search {
    
    private String content;

    public Search() {
    }

    public Search(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Search{" + "content=" + content + '}';
    }
}
