/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecaocartoes_colecionador;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author davi
 */
public class Colecao implements Serializable {
    
    long id_colecionador;
    Map<Cartao,Integer> cartoesQtd;
    Map<Cartao,Double> cartoesPreco;
    boolean trava;

    public Colecao(long id_colecionador) {
        this.id_colecionador = id_colecionador;
        this.cartoesQtd = new HashMap();
        this.cartoesPreco = new HashMap();
        Random random = new Random();
        for (Cartao cartao: Cartao.values()) {
            cartoesQtd.put(cartao, 0);
            double preco = random.nextDouble() * 10;
            cartoesPreco.put(cartao, preco);
        }
        this.trava = false;
    }
    
    enum Cartao {
        CIDADE, ANIMAL, PAISAGEM
    }
    
}
