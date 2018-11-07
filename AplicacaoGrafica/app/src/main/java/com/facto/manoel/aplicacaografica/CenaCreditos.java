package com.facto.manoel.aplicacaografica;

import com.facto.manoel.aplicacaografica.AndGraph.AGGameManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGScene;
import com.facto.manoel.aplicacaografica.AndGraph.AGScreenManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSprite;

public class CenaCreditos extends AGScene {


    AGSprite gato = null;
    public CenaCreditos(AGGameManager gameManager) {
        super(gameManager);
    }

    @Override
    public void init() {
        setSceneBackgroundColor(1,0,0);

        gato = createSprite(R.mipmap.canguru,2,4);
        gato.setScreenPercent(30,15);
        gato.vrPosition.setX(AGScreenManager.iScreenWidth /2);
        gato.vrPosition.setY(AGScreenManager.iScreenHeight /2);
        //Quantidade de Quadros por segundo em que será trocado os quadros
        //Se colocar 10, será 10 vezes a imagem irá trocar por segundo
        //segundo parametro é se a imagem irá repetir
        //terceiro, primeira imagem
        //quarto, ultima imagem
        gato.addAnimation(10,true,0,7);
        //Configura o espelhamento
        //Tendo duas opções, vertical e horizontal
        gato.iMirror = AGSprite.HORIZONTAL;
        //Transparencia 0 a 1
        gato.fAlpha = 0.3f;

    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        //Muda o angulo com fAngle
        gato.fAngle += 5f;
    }
}
