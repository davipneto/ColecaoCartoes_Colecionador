/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecaocartoes;

import java.rmi.*;
import java.util.List;

/**
 *
 * @author davi
 */
public interface InterfaceCoordenador extends Remote {
    
    public void efetivacaoOk(int transacao) throws RemoteException;
    public void obterDecisao(int transacao) throws RemoteException;
    
    public void trocarCartoes(int transacao, Colecao.Cartao tipo1, Colecao.Cartao tipo2, Integer qntd1, Integer qntd2, Long id_colec1, Long id_colec2) throws RemoteException;
    
    /**
     * Consulta as Coleções de todos os Colecionadores do Sistema
     * @return uma lista de colecoes
     * @throws RemoteException 
     */
    public List<Colecao> consultarColecoes(int transacao) throws RemoteException;
    
    /**
     * Registra o colecionador no sistema
     * @param col a interface do colecionador
     * @return um id único para o colecionador
     * @throws RemoteException 
     */
    public long registraColecionador(int transacao, InterfaceColecionador col) throws RemoteException;
    
}
