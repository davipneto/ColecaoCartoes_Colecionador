package colecaocartoes;

import colecaocartoes.Colecao.Cartao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A classe ColecionadorImpl implementa os métodos remotos da interface
 * InterfaceColecionador.
 *
 * @author Davi Pereira Neto
 * @author Geovana Franco Santos
 */
public class ColecionadorImpl extends UnicastRemoteObject implements InterfaceColecionador {

    public InterfaceCoordenador coord;
    public Colecao colecao;
    public long id;
    public static File log1;

    /**
     * Construtor da classe que cria uma referência do coordenador disponível,
     * registra o colecionador na base de dados do coordenador e cria o
     * cabeçalho do log do colecionador
     *
     * @throws RemoteException
     */
    public ColecionadorImpl() throws RemoteException {
        try {
            //cria um registo para o 
            Registry refSN = LocateRegistry.getRegistry("localhost", 1099);
            //pega no serviços de nomes a referência do servidor
            coord = (InterfaceCoordenador) refSN.lookup("RefCoordenador");
            //registra o colecionador na base de dados do coordenador
            //coordenador retorna o id do colecionador
            id = coord.registraColecionador(0, this);
            //inicializa coleção com o id do colecionador
            this.colecao = new Colecao(id);
            //cria um arquivo de log
            String endFile = "E:\\Geovana\\UTFPR\\9º Semestre\\Sistemas Distribuidos\\ColecaoCartoes_Colecionador\\src\\colecaocartoes\\log" + id + ".txt";
            this.log1 = new File(endFile);
            log1.createNewFile();

            //escreve no arquivo o cabeçalho do log
            BufferedWriter buffLog = new BufferedWriter(new FileWriter(this.log1, true));
            buffLog.write("Log do colecionador " + this.id);
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

    /**
     * Método para verificar se o colecionador deseja efetivar a transação.
     *
     * @param transacao com o número da transação
     * @param tipoTransacao com o tipo de transação a ser realizada
     * @param cartao com o tipo de cartão a ser transacionado
     * @param qntd com a quantidade a ser transacionado
     * @return boolean com a decisão do colecionador
     * @throws RemoteException
     */
    @Override
    public boolean desejaEfetivar(int transacao, String tipoTransacao, Colecao.Cartao cartao, Integer qntd) throws RemoteException {
        BufferedWriter buffLog = null;
        int qntdTrans = 0;
        try {
            buffLog = new BufferedWriter(new FileWriter(this.log1, true));
            if (tipoTransacao.equals("remover")) {
                while (!colecao.trava) {
                    //coloca trava na coleção
                    colecao.setTrava(true);
                    //verifica se possui a quantidade que deseja remover
                    //se não possui remove o quanto tiver
                    if (colecao.cartoesQtd.get(cartao) <= qntd) {
                        qntdTrans = colecao.cartoesQtd.get(cartao);
                    } else {
                        qntdTrans = qntd;
                    }
                    //salva no log transação
                    buffLog.write(transacao + " remover " + cartao + " " + qntd + " provisório");
                    buffLog.newLine();
                    //libera a trava
                    colecao.setTrava(false);
                    //retorna status final da transação
                    return true;
                }
                return false;
            } else {
                while (!colecao.trava) {
                    //coloca trava na coleção
                    colecao.setTrava(true);
                    //atualiza a quantidade do tipo de cartão na coleção
                    //colecao.cartoesQtd.put(cartao, colecao.cartoesQtd.get(cartao) + qntd);
                    //escreve no log status final da transação
                    buffLog.write(transacao + " inserir " + cartao + " " + qntd + " provisório");
                    buffLog.newLine();
                    //libera trava
                    colecao.setTrava(false);
                    //retorna status final da transação
                    return true;
                }
            }
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

    /**
     * Método para efetivar uma transação.
     *
     * @param transacao com o número da transação
     * @throws RemoteException
     */
    @Override
    public void efetivar(int transacao) throws RemoteException {
        try {
            //buscar no log as transações
            BufferedReader buffLog = new BufferedReader(new FileReader(this.log1));
            String linha;
            String linha_s[];
            while ((linha = buffLog.readLine()) != null) {
                linha_s = linha.split(" ");
                if(linha_s[0].equals(String.valueOf(transacao))){
                    if(linha_s[1].equals("remover")){
                        this.removerCartão(transacao, Cartao.valueOf(linha_s[2]), Integer.parseInt(linha_s[3]));
                    } else if (linha_s[1].equals("inserir")){
                        this.inserirCartão(transacao, Cartao.valueOf(linha_s[2]), Integer.parseInt(linha_s[3]));
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ColecionadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para abortar uma transação.
     *
     * @param transacao com o número da transação
     * @throws RemoteException
     */
    @Override
    public void abortar(int transacao) throws RemoteException {
            BufferedWriter buffLog = null;
        try {
            buffLog = new BufferedWriter(new FileWriter(this.log1, true));
            //Transação abortada
            buffLog.write(transacao + " abortada");
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
    }

    /**
     * Método que retorna a coleção do colecionador.
     *
     * @param transacao com o número da transação
     * @return com a coleção do colecionador
     * @throws RemoteException
     */
    @Override
    public Colecao getColecao(int transacao) throws RemoteException {
        BufferedWriter buffLog = null;
        try {
            buffLog = new BufferedWriter(new FileWriter(this.log1, true));
            //escreve no log a tentativa de transação
            buffLog.write(transacao + " GetColecao " + this.id);
            buffLog.newLine();
            //enquanto não esta travada a coleção
            while (!colecao.isTrava()) {
                //escreve o status final da transação
                buffLog.write(transacao + " efetivada");
                buffLog.newLine();
                //retorna coleção
                return colecao;
            }
            //se não der certo escreve status final da transação
            buffLog.write(transacao + " abortada");
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
        //retorna nulo
        return null;
    }

    /**
     * Método para remover a quantidade de cartão da coleção
     *
     * @param transacao com o número da transação
     * @param cartao com o tipo de cartão a ser removido
     * @param qntd com a quantidade a ser removida
     * @return boolean com o status final da transação
     * @throws RemoteException
     */
    @Override
    public boolean removerCartão(int transacao, Colecao.Cartao cartao, Integer qntd) throws RemoteException {
        BufferedWriter buffLog = null;
        try {
            Integer qntdTrans = 0;
            buffLog = new BufferedWriter(new FileWriter(this.log1, true));
            //coloca o nome da transação
            buffLog.write(transacao + " removerCartão " + cartao + " " + qntd);
            buffLog.newLine();
            //enquanto não está travada a coleção
            while (!colecao.trava) {
                //coloca trava na coleção
                colecao.setTrava(true);
                //verifica se possui a quantidade que deseja remover
                //se não possui remove o quanto tiver
                if (colecao.cartoesQtd.get(cartao) <= qntd) {
                    qntdTrans = colecao.cartoesQtd.get(cartao);
                } else {
                    qntdTrans = qntd;
                }
                //atualiza a quantidade do tipo de cartão na coleção
                colecao.cartoesQtd.put(cartao, colecao.cartoesQtd.get(cartao) - qntdTrans);
                //escreve no log status final da transação
                buffLog.write(transacao + " efetivada");
                buffLog.newLine();
                //libera a trava
                colecao.setTrava(false);
                //retorna status final da transação
                return true;
            }
            //caso de errado escreve no log status final da transação
            buffLog.write(transacao + " abortada");
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
        //retorna status final da transação
        return false;
    }

    /**
     * Método para inserir uma quantidade de cartão na coleção
     *
     * @param transacao com o número da transação
     * @param cartao com o tipo de cartão a ser inserido
     * @param qntd com a quantidade a ser inserida
     * @return boolean com o status final da transação
     * @throws RemoteException
     */
    @Override
    public boolean inserirCartão(int transacao, Colecao.Cartao cartao, Integer qntd) throws RemoteException {
        BufferedWriter buffLog = null;
        try {
            buffLog = new BufferedWriter(new FileWriter(this.log1, true));
            //coloca o nome da transação
            buffLog.write(transacao + " inserirCartão " + cartao + " " + qntd);
            buffLog.newLine();
            //enquanto não estiver travada a coleção
            while (!colecao.trava) {
                //coloca trava na coleção
                colecao.setTrava(true);
                //atualiza a quantidade do tipo de cartão na coleção
                colecao.cartoesQtd.put(cartao, colecao.cartoesQtd.get(cartao) + qntd);
                //escreve no log status final da transação
                buffLog.write(transacao + " efetivada");
                buffLog.newLine();
                //libera trava
                colecao.setTrava(false);
                //retorna status final da transação
                return true;
            }
            //caso de errado escreve no log status final da transação
            buffLog.write(transacao + " abortada");
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
        //retorna status final da transação
        return false;
    }
}
