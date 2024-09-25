/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

/**
 *
 * @author Felippe
 */

public class PessoaFisicaRepo implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<PessoaFisica> listaPF = new ArrayList<>();
    
    public void inserir(PessoaFisica pF) {
        listaPF.add(pF);
    }
    
    public PessoaFisica obter(int id) {
        for (PessoaFisica pF : listaPF) {
            if (pF.getID() == id) {
                return pF;
            }
        }
        return null;
    }
    
    public void alterar(PessoaFisica pF) {
        for (int i = 0; i < listaPF.size(); i++) {
            if (pF.getID() == listaPF.get(i).getID()) {
                listaPF.set(i, pF);
                return;
            }
        }
    }
    
    public void excluir(int id) {
        for (int i = 0; i < listaPF.size(); i++) {
            if (listaPF.get(i).getID() == id) {
                listaPF.remove(i);
                return;
            }
        }
    }
    
    public List<PessoaFisica> obterTodos() {
        return listaPF;
    }
    
    public void persistir(String filename) throws IOException {
        try (ObjectOutputStream OOS = new ObjectOutputStream (new FileOutputStream (filename))) {
            OOS.writeObject(listaPF);
        }
        catch (IOException e) {
            throw e;
        }
    }
    
    public void recuperar(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(filename))) {
            listaPF.clear();
            List<PessoaFisica> listaRec = (List<PessoaFisica>) OIS.readObject();
            listaPF.addAll(listaRec);
        }
        catch (IOException e) {
            throw e;
        }
    }
}