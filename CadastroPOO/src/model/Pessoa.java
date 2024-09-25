/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Felippe
 */

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public void setID(int id) {
        this.id = id;
    }
     
    public int getID() {
        return id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void exibir() {
        System.out.println("ID: " + getID());
        System.out.println("Nome: " + getNome());
    }
}
