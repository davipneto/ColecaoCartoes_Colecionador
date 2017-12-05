/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecaocartoes;

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
    
    public InterfaceCoordenador coord;
    public Colecao colecao;
    public long id;
    
    public ColecionadorImpl() throws RemoteException {
        try {
            Registry refSN = LocateRegistry.getRegistry("localhost", 1099);
            System.out.println("Registrou");
            //pega no serviços de nomes a referência do servidor
            coord = (InterfaceCoordenador) refSN.lookup("RefCoordenador");
            System.out.println("depois de pegar referencia do servidor");
            id = coord.registraColecionador(this);
            this.colecao = new Colecao(id);
            coord.efetivacaoOk();
        } catch (NotBoundException ex) {
            System.out.println("Não consegue dar bound");
            Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            System.out.println("Não consegue acesso");
            Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean desejaEfetivar() throws RemoteException {
        return false;
    }

    @Override
    public void efetivar() throws RemoteException {
        
    }

    @Override
    public void abortar() throws RemoteException {
        
    }

    @Override
    public Colecao getColecao() throws RemoteException {
        do{
        if(!colecao.isTrava())
            return colecao;
        }while(!colecao.isTrava());
        return null;
    }

    @Override
    public boolean removerCartão(Colecao.Cartao cartao, Integer qntd) throws RemoteException {
        Integer qntdTrans = 0;
        do{
            if(!colecao.isTrava()){
                colecao.setTrava(true);
                if(colecao.cartoesQtd.get(cartao)<=qntd)
                    qntdTrans = colecao.cartoesQtd.get(cartao);
                else
                    qntdTrans = qntd;
                colecao.cartoesQtd.put(cartao, colecao.cartoesQtd.get(cartao)-qntdTrans);
                colecao.setTrava(false);
                return true;
            }
        }while(colecao.trava);
        return false;
    }

    @Override
    public boolean inserirCartão(Colecao.Cartao cartao, Integer qntd) throws RemoteException {
        do{
            if(!colecao.isTrava()){
                colecao.setTrava(true);
                colecao.cartoesQtd.put(cartao, colecao.cartoesQtd.get(cartao)+qntd);
                colecao.setTrava(false);
                return true;
            }
        }while(colecao.trava);
        return false;
    }
}
