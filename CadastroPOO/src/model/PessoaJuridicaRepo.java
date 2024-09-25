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

public class PessoaJuridicaRepo implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<PessoaJuridica> listaPJ = new ArrayList<>();
    
    public void inserir(PessoaJuridica pJ) {
        listaPJ.add(pJ);
    }
    
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pJ : listaPJ) {
            if (pJ.getID() == id) {
                return pJ;
            }
        }
        return null;
    }
    
    public void alterar(PessoaJuridica pJ) {
        for (int i = 0; i < listaPJ.size(); i++) {
            if (pJ.getID() == listaPJ.get(i).getID()) {
                listaPJ.set(i, pJ);
                return;
            }
        }
    }
    
    public void excluir(int id) {
        for (int i = 0; i < listaPJ.size(); i++) {
            if (listaPJ.get(i).getID() == id) {
                listaPJ.remove(i);
                return;
            }
        }
    }
    
    public List<PessoaJuridica> obterTodos() {
        return listaPJ;
    }
    
    public void persistir(String filename) throws IOException {
        try (ObjectOutputStream OOS = new ObjectOutputStream (new FileOutputStream (filename))) {
            OOS.writeObject(listaPJ);
        }
        catch (IOException e) {
            throw e;
        }
    }
    
    public void recuperar(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(filename))) {
            listaPJ.clear();
            List<PessoaJuridica> listaRec = (List<PessoaJuridica>) OIS.readObject();
            listaPJ.addAll(listaRec);
        }
        catch (IOException e) {
            throw e;
        }
    }
}
