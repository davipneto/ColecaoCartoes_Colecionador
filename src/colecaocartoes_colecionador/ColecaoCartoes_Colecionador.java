/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecaocartoes_colecionador;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davi
 */
public class ColecaoCartoes_Colecionador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ColecionadorImpl colecionador = new ColecionadorImpl();
            //chamar o Frame
        } catch (RemoteException ex) {
            Logger.getLogger(ColecaoCartoes_Colecionador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
