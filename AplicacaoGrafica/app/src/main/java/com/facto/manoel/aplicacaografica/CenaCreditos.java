package com.facto.manoel.aplicacaografica;

import com.facto.manoel.aplicacaografica.AndGraph.AGGameManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGInputManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGScene;
import com.facto.manoel.aplicacaografica.AndGraph.AGScreenManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSoundManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSprite;

public class CenaCreditos extends AGScene {


    AGSprite canguru = null;
    AGSprite gato = null;
    int animacao = 0;
    public CenaCreditos(AGGameManager gameManager) {
        super(gameManager);
    }
    int codigoSom = 0;
    @Override
    public void init() {
        setSceneBackgroundColor(1,0,0);

        //Declara um efeito de som
        codigoSom = AGSoundManager.vrSoundEffects.loadSoundEffect("toc");

        canguru = createSprite(R.mipmap.canguru,2,4);
        gato = createSprite(R.mipmap.gato,8,8);
        canguru.setScreenPercent(30,15);
        gato.setScreenPercent(30,20);
        canguru.vrPosition.setX(AGScreenManager.iScreenWidth /2);
        canguru.vrPosition.setY(AGScreenManager.iScreenHeight /2);
        gato.vrPosition.setX(AGScreenManager.iScreenWidth  * 0.5f);
        gato.vrPosition.setY(AGScreenManager.iScreenHeight * 0.75f);
        //Quantidade de Quadros por segundo em que será trocado os quadros
        //Se colocar 10, será 10 vezes a imagem irá trocar por segundo
        //segundo parametro é se a imagem irá repetir
        //terceiro, primeira imagem
        //quarto, ultima imagem
        canguru.addAnimation(10,true,0,7);
        //Primeira animação do gato, quadros de Pulo - 0
        gato.addAnimation(15,true,0,15);
        //Segunda animação do gato, nervosismo - 1
        gato.addAnimation(10,true,16,28);
        //Terceira animação do gato, correndo - 2
        gato.addAnimation(100,true,29,40);
        //Configura o espelhamento
        //Tendo duas opções, vertical e horizontal
        canguru.iMirror = AGSprite.HORIZONTAL;
        //Transparencia 0 a 1
        canguru.fAlpha = 0.3f;
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {

        //Se o usuário clicar na tela
        if(AGInputManager.vrTouchEvents.screenClicked()){
            animacao++;

            //Ativa o efeito de som
            AGSoundManager.vrSoundEffects.play(codigoSom);

            //As animações vão de 0 a dois, posi foi adicionado 3 animações
            //Então, sempre q o usuario clica na tela, muda a animação.
            if(animacao > 2)
                animacao = 0;

            gato.setCurrentAnimation(animacao);
        }
//        gato.fAngle += 10f;
        //Muda o angulo com fAngle
        canguru.fAngle += 5f;
    }
}
