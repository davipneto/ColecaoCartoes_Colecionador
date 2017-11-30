/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecaocartoes_colecionador;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davi
 */
public class ColecionadorImpl extends UnicastRemoteObject implements InterfaceColecionador {
    
    InterfaceCoordenador coord;
    Colecao colecao;
    long id;
    
    public ColecionadorImpl() throws RemoteException {
        try {
            Registry refSN = LocateRegistry.getRegistry("localhost", 1099);
            //pega no serviços de nomes a referência do servidor
            coord = (InterfaceCoordenador) refSN.lookup("RefCoordenador");
            id = coord.registraColecionador(this);
            this.colecao = new Colecao(id);
        } catch (NotBoundException ex) {
            Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean desejaEfetivar() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void efetivar() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void abordar() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Colecao getColecao() throws RemoteException {
        if(colecao.trava)
            return null;
        else
            return colecao;
    }
    
}
