/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmes_rapido;

import model.Clientes;
import model.Filme;
import model.Filmes;
import ui.LoginDialog;

/**
 *
 * @author alan
 */
public class Filmes_rapido {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //LoginDialog loginDialog = new LoginDialog();
        // TODO code application logic here
        //Clientes clientes = new Clientes();
        /*Filmes filmes = new Filmes();
        Filme filme = new Filme();
        filme.setTitulo("testando");
        filme.setAno(2018);
        filmes.adicionarFilme(filme);
        filmes.serializaLista("filmes.dat");   
        */
        
        
        new LoginDialog().setVisible(true);
    }
    
}
