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
public class Filmes {

    private List<Filme> filmes = new ArrayList<>();

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void removerFilme(Filme filme) {
        filmes.remove(filme);
    }

    public Filme procurarFilme(String titulo ) {
        for (Filme f : filmes) {
            if (f.getTitulo()== titulo) {
                return f;
            }
        }
        return null;
    }

    public Filme retrieve(Filme filme) {
        if (filmes.size() > 0) {
            for (int i = 0; i < filmes.size(); i++) {
                String chaveNaLista = filmes.get(i).getTitulo();
                String chaveProcurada = filme.getTitulo();
                if (chaveNaLista.equals( chaveProcurada)) {
                    return filmes.get(i);
                }
            }
        }
        return null;//não achou na lista
    }

    public void desSerializaLista(String arquivo) {
        FileInputStream arqLeitura = null;
        ObjectInputStream in = null;
        filmes.clear();
        try {
            //arquivo onde estao os dados serializados
            arqLeitura = new FileInputStream(arquivo);

            //objeto que vai ler os dados do arquivo
            in = new ObjectInputStream(arqLeitura);

            //recupera os dados
            filmes = (ArrayList<Filme>) in.readObject();

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
            out.writeObject(filmes);
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
    
    public void listarTodos() {
        if (filmes.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            for (int i = 0; i < filmes.size(); i++) {
                System.out.println(""+ filmes.get(i).getTitulo());
            }
        }
    }

}


