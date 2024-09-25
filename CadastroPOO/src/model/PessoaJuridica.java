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

public class PessoaJuridica extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cnpj;
    
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getCNPJ() {
        return cnpj;
    }
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + getCNPJ());
    }
}
