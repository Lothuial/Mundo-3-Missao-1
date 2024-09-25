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

public class PessoaFisica extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cpf;
    private int idade;
    
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }
    
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCPF() {
        return cpf;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public int getIdade() {
        return idade;
    }
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + getCPF());
        System.out.println("Idade: " + getIdade());
    }
}
