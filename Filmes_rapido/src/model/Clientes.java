/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alan
 */
public class Clientes {
    private List<Cliente> clientes = new ArrayList<>();


    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
   
    public void removerCliente(Cliente cliente){
        clientes.remove(cliente);
    }

    public Cliente procurarCliente(int cpf){
        for( Cliente c : clientes ){
            if(c.getCpf()==cpf){
                return c;
            }
        }
        return null;
    }
    
    public Cliente retrieve(Cliente cliente) {
        if (clientes.size() > 0) {
            for (int i = 0; i < clientes.size(); i++) {
                int chaveNaLista = clientes.get(i).getCpf();
                int chaveProcurada = cliente.getCpf();
                if (chaveNaLista==chaveProcurada) {
                    return clientes.get(i);
                }
            }
        }
        return null;//não achou na lista
    }
    
    public void desSerializaLista(String arquivo) {
        FileInputStream arqLeitura = null;
        ObjectInputStream in = null;
        clientes.clear();
        try {
            //arquivo onde estao os dados serializados
            arqLeitura = new FileInputStream(arquivo);

            //objeto que vai ler os dados do arquivo
            in = new ObjectInputStream(arqLeitura);

            //recupera os dados
            clientes = (ArrayList<Cliente>) in.readObject();

        } catch (ClassNotFoundException ex) {
            System.out.println("erro 1: " + ex);
        } catch (IOException ex) {
            System.out.println("erro 2: " + ex);
        } finally {
            try {
                arqLeitura.close();
                in.close();
            } catch (IOException ex) {
                System.out.println("erro 3: " + ex);
            }
        }

    }

    public void serializaLista(String arquivo) {

        FileOutputStream arq = null;
        ObjectOutputStream out = null;
        try {
            //arquivo no qual os dados vao ser gravados
            arq = new FileOutputStream(arquivo);

            //objeto que vai escrever os dados
            out = new ObjectOutputStream(arq);
            out.writeObject(clientes);
        } catch (IOException ex) {
            System.out.println("erro: " + ex);
        } finally {
            try {
                arq.close();
                out.close();
            } catch (IOException ex) {
            }
        }
    }
    
}