package com.facto.manoel.aplicacaografica;

import android.os.Bundle;

import com.facto.manoel.aplicacaografica.AndGraph.AGActivityGame;

public class Principal extends AGActivityGame {


    CenaMenu cenaMenu = null;
    CenaPrimeiraFase cenaFase = null;
    CenaSobre cenaSobre = null;
    CenaGamever cenaGameOver = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        /**
         * Init: inicializa a aplicação
         * Params: própria activity e se vai usar ou não o acelerrometro
         * */

        init(this, false);

        //Cria os objetos das cenas
        this.cenaMenu = new CenaMenu(getGameManager());
        this.cenaFase = new CenaPrimeiraFase(getGameManager());
        this.cenaSobre = new CenaSobre(getGameManager());
        this.cenaGameOver = new CenaGamever(getGameManager());

        getGameManager().addScene(this.cenaMenu);
        getGameManager().addScene(this.cenaFase);
        getGameManager().addScene(this.cenaSobre);
        getGameManager().addScene(this.cenaGameOver);


    }
}
