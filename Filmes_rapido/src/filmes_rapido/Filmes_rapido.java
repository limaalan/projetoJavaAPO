/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmes_rapido;

import model.Clientes;
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
        Clientes clientes = new Clientes();
        
        new LoginDialog().setVisible(true);
    }
    
}
