/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecaocartoes;

import java.rmi.*;

/**
 *
 * @author davi
 */
public interface InterfaceColecionador extends Remote {
    
    public boolean desejaEfetivar(int transacao) throws RemoteException;
    public void efetivar(int transacao) throws RemoteException;
    public void abortar(int transacao) throws RemoteException;
    public boolean removerCartão(int transacao, Colecao.Cartao cartao, Integer qntd) throws RemoteException;
    public boolean inserirCartão(int transacao, Colecao.Cartao cartao, Integer qntd) throws RemoteException;
    public Colecao getColecao(int transacao) throws RemoteException;
    
}
