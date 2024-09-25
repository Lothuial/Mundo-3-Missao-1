/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author Felippe
 */

public class CadastroPOO {
    
     /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */

public static void main(String[] args) throws Exception {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisica fis1 = new PessoaFisica(1, "Daniel Araujo", "555.814.674-55", 25);
        PessoaFisica fis2 = new PessoaFisica(2, "Eduardo Azevedo", "236.826.030-77", 43);
        repo1.inserir(fis1);
        repo1.inserir(fis2);
        repo1.persistir("dadosPF");
        System.out.println("Dados de Pessoa Fisica Armazenados.");
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        repo2.recuperar("dadosPF");
        System.out.println("Dados de Pessoa Fisica Recuperados.");
        for (PessoaFisica pF : repo2.obterTodos()) {
            pF.exibir();
        }
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        PessoaJuridica jur1 = new PessoaJuridica(1, "Destino dos Sonhos", "80.760.646/0001-06");
        PessoaJuridica jur2 = new PessoaJuridica(2, "Roteiros Magicos", "87.651.749/0001-87");
        repo3.inserir(jur1);
        repo3.inserir(jur2);
        repo3.persistir("dadosPJ");
        System.out.println("Dados de Pessoa Fisica Armazenados.");
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar("dadosPJ");
        System.out.println("Dados de Pessoa Fisica Recuperados.");
        for  (PessoaJuridica pJ : repo4.obterTodos()) {
            pJ.exibir();
        }
    }
	
}