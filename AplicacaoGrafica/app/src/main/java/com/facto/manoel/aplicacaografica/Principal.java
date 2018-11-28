package com.facto.manoel.aplicacaografica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facto.manoel.aplicacaografica.AndGraph.AGActivityGame;

public class Principal extends AGActivityGame {



    CenaAbertura abertura = null;
    CenaMenu cenaMenu = null;
    CenaCreditos cenaCreditos = null;
    CenaPrimeiraFase primeiraFase = null;
    CenaSobre cenaSobre = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        /**
         * Init: inicializa a aplicação
         * Params: própria activity e se vai usar ou não o acelerrometro
         * */

        init(this, false);

        //Cria os objetos das cenas
        abertura = new CenaAbertura(getGameManager());
        cenaMenu = new CenaMenu(getGameManager());
        cenaCreditos = new CenaCreditos(getGameManager());
        this.primeiraFase = new CenaPrimeiraFase(getGameManager());
        this.cenaSobre = new CenaSobre(getGameManager());

        getGameManager().addScene(this.cenaSobre);
        getGameManager().addScene(this.primeiraFase);
        //Registra as cenas no GameManager
//        getGameManager().addScene(abertura);
//        getGameManager().addScene(cenaMenu);
//        getGameManager().addScene(cenaCreditos);




    }
}
