package com.facto.manoel.aplicacaografica;

import com.facto.manoel.aplicacaografica.AndGraph.AGAnimation;
import com.facto.manoel.aplicacaografica.AndGraph.AGGameManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGInputManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGScene;
import com.facto.manoel.aplicacaografica.AndGraph.AGScreenManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSoundEffect;
import com.facto.manoel.aplicacaografica.AndGraph.AGSoundManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSprite;
import com.facto.manoel.aplicacaografica.AndGraph.AGTimer;

public class CenaMenu extends AGScene {

    AGSprite imglogo = null;
    AGSprite imgplay = null;
    AGSprite imgpause = null;
    AGSprite imgexit = null;
    AGTimer tempo = null;
    AGGameManager gameManager = null;
    int codigoSom = 0;

    CenaMenu(AGGameManager gameManager){
        super(gameManager);
        this.gameManager =gameManager;
    }
    @Override
    public void init() {

        //Gerenciador de sons
//        AGSoundManager.vrMusic.loadMusic("musica.mp3",true);
//        AGSoundManager.vrMusic.play();




        tempo = new AGTimer(2000);
        setSceneBackgroundColor(0,0,0);
        imglogo = createSprite(R.mipmap.logo, 1,1);
        imglogo.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.50f, AGScreenManager.iScreenHeight * 0.60f);
        imglogo.setScreenPercent(100,50);
        imgplay = createSprite(R.mipmap.play, 1,1);
        imgplay.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.50f, AGScreenManager.iScreenHeight * 0.30f);
        imgplay.setScreenPercent(10,5);
        imgpause = createSprite(R.mipmap.pausa, 1,1);
        imgpause.setScreenPercent(10,5);
        imgpause.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.50f, AGScreenManager.iScreenHeight * 0.20f);
        imgexit = createSprite(R.mipmap.exit, 1,1);
        imgexit.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.50f, AGScreenManager.iScreenHeight * 0.10f);
        imgexit.setScreenPercent(10,5);
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    float tamanho = 10;
    float largura = 5;
    float direcao = 1;

    @Override
    public void loop() {

        if(imgplay.collide(AGInputManager.vrTouchEvents.getLastPosition())){
            vrGameManager.setCurrentScene(0);
            return;
        }
        if(imgpause.collide(AGInputManager.vrTouchEvents.getLastPosition())){
            vrGameManager.setCurrentScene(2);
            return;
        }
        if(imgexit.collide(AGInputManager.vrTouchEvents.getLastPosition())){
            this.gameManager.vrActivity.finish();
        }
//        imgplay.setScreenPercent((int)tamanho,(int)largura);
//        //imgplay.setScreenPercent(10,5);
//        tempo.update();
//        if(tempo.isTimeEnded()){
//            if(tamanho >= 40 && largura >= 20 || tamanho <= 10 && largura <= 5){
//                direcao *= -1;
//            }
//        }
//
//
//        tamanho += direcao * 0.4;
//        largura += direcao * 0.4;
//
//        if(AGInputManager.vrTouchEvents.screenClicked()){
//            vrGameManager.setCurrentScene(2);
//        }
    }
}
