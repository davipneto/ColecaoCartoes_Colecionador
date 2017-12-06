package colecaocartoes;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe principal do colecionador que cria um colecionador e inicia interface
 * gráfica.
 *
 * @author Davi Pereira Neto
 * @author Geovana Franco Santos
 */
public class ColecaoCartoes_Colecionador {

    /**
     * Método principal.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //cria implementação do colecionador
            ColecionadorImpl colecionador = new ColecionadorImpl();
            //invoca interface gráfica
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ColecaoCartoes(colecionador).setVisible(true);
                }
            });
        } catch (RemoteException ex) {
            Logger.getLogger(ColecaoCartoes_Colecionador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
