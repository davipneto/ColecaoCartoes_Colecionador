/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecaocartoes_colecionador;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author davi
 */
public interface InterfaceColecionador extends Remote {
    
    public boolean desejaEfetivar() throws RemoteException;
    public void efetivar() throws RemoteException;
    public void abordar() throws RemoteException;
    public Colecao getColecao() throws RemoteException;
    
}
