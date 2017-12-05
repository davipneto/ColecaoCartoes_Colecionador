/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecaocartoes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    public static File log1 = new File("/src/colecaocartoes/log.txt");
    
    
    public ColecionadorImpl() throws RemoteException {
        try {
            Registry refSN = LocateRegistry.getRegistry("localhost", 1099);
            System.out.println("Registrou");
            //pega no serviços de nomes a referência do servidor
            coord = (InterfaceCoordenador) refSN.lookup("RefCoordenador");
            System.out.println("depois de pegar referencia do servidor");
            id = coord.registraColecionador(0, this);
            this.colecao = new Colecao(id);
            log1.createNewFile();
            
            BufferedWriter buffLog = new BufferedWriter(new FileWriter(this.log1));
            buffLog.write("Log do colecionador "+ this.id);
            buffLog.newLine();
            
            buffLog.close();
            
        } catch (NotBoundException ex) {
            System.out.println("Não consegue dar bound");
            Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            System.out.println("Não consegue acesso");
            Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean desejaEfetivar(int transacao) throws RemoteException {
        return false;
    }

    @Override
    public void efetivar(int transacao) throws RemoteException {
        
    }

    @Override
    public void abortar(int transacao) throws RemoteException {
        
    }

    @Override
    public Colecao getColecao(int transacao) throws RemoteException {
        BufferedWriter buffLog = null;
        try {
            buffLog = new BufferedWriter(new FileWriter(this.log1));
            buffLog.write("Log do colecionador "+ this.id);
            buffLog.newLine();
            buffLog.close();
            
            buffLog.write("Tentativa GetColecao "+ this.id);
            buffLog.newLine();
            do{
                if(!colecao.isTrava()){
                    buffLog.write("Sucesso GetColecao "+ this.id);
                    buffLog.newLine();
                    return colecao;
                }
            }while(!colecao.isTrava());
            buffLog.write("Falha GetColecao "+ this.id);
            buffLog.newLine();
        } catch (IOException ex) {
            Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                buffLog.close();
            } catch (IOException ex) {
                Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public boolean removerCartão(int transacao, Colecao.Cartao cartao, Integer qntd) throws RemoteException {
        BufferedWriter buffLog = null;
        try {
            Integer qntdTrans = 0;
            buffLog = new BufferedWriter(new FileWriter(this.log1));
            buffLog.write("Tentativa Remover "+ this.id + " " + cartao + " " + qntd);
            buffLog.newLine();
            do{
                if(!colecao.isTrava()){
                    colecao.setTrava(true);
                    if(colecao.cartoesQtd.get(cartao)<=qntd)
                        qntdTrans = colecao.cartoesQtd.get(cartao);
                    else
                        qntdTrans = qntd;
                    colecao.cartoesQtd.put(cartao, colecao.cartoesQtd.get(cartao)-qntdTrans);
                    buffLog.write("Sucesso Remover "+ this.id + " " + cartao + " " + qntd);
                    buffLog.newLine();
                    colecao.setTrava(false);
                    return true;
                }
            }while(colecao.trava);
            buffLog.write("Falha Remover "+ this.id + " " + cartao + " " + qntd);
            buffLog.newLine();
        } catch (IOException ex) {
            Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                buffLog.close();
            } catch (IOException ex) {
                Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean inserirCartão(int transacao, Colecao.Cartao cartao, Integer qntd) throws RemoteException {
        BufferedWriter buffLog = null;
        try {
            buffLog = new BufferedWriter(new FileWriter(this.log1));
            buffLog.write("Tentativa Inserir "+ this.id + " " + cartao + " " + qntd);
            buffLog.newLine();
            System.out.println("Tentativa Inserir "+ this.id + " " + cartao + " " + qntd);
            do{
                if(!colecao.isTrava()){
                    colecao.setTrava(true);
                    colecao.cartoesQtd.put(cartao, colecao.cartoesQtd.get(cartao)+qntd);
                    buffLog.write("Sucesso Inserir "+ this.id + " " + cartao + " " + qntd);
                    buffLog.newLine();
                    System.out.println("Sucesso Inserir "+ this.id + "  " + cartao + " " + qntd);
                    colecao.setTrava(false);
                    return true;
                }
            }while(colecao.trava);
            buffLog.write("Falha Inserir "+ this.id + " " + cartao + " " + qntd);
            buffLog.newLine();
            System.out.println("Falha Inserir "+ this.id + "  " + cartao + " " + qntd);
        } catch (IOException ex) {
            Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                buffLog.close();
            } catch (IOException ex) {
                Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
