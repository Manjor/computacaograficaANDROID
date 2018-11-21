package com.facto.manoel.aplicacaografica;

import com.facto.manoel.aplicacaografica.AndGraph.AGGameManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGScene;
import com.facto.manoel.aplicacaografica.AndGraph.AGScreenManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSprite;

public class CenaPrimeiraFase extends AGScene {

    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/



    AGGameManager agGameManager = null;
    AGSprite background = null;
    AGSprite parado = null;
    AGSprite andando = null;
    AGSprite atirando = null;
    AGSprite pulando = null;
    AGSprite morendo = null;
    AGSprite abaixando = null;
    AGSprite cachorrorun = null;
    public CenaPrimeiraFase(AGGameManager pManager) {
        super(pManager);
        this.agGameManager = pManager;
    }

    @Override
    public void init() {
        setSceneBackgroundColor(0.2f,0.2f,0.4f);
        this.background = createSprite(R.mipmap.inferno,1,1);
        this.background.setScreenPercent(100,100);
        this.background.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        this.background.vrPosition.setY(AGScreenManager.iScreenHeight/2);

        this.parado = createSprite(R.mipmap.herosprite,8,5);
        this.parado.setScreenPercent(20,25);
        this.parado.vrPosition.setX(AGScreenManager.iScreenWidth * 0.10f);
        this.parado.vrPosition.setY(AGScreenManager.iScreenHeight * 0.10f);
        this.parado.addAnimation(10,true,0,7);

//        this.andando = createSprite(R.mipmap.herosprite, 8,5);
//        this.andando.setScreenPercent(20,25);
//        this.andando.vrPosition.setX(AGScreenManager.iScreenWidth * 0.25f);
//        this.andando.vrPosition.setY(AGScreenManager.iScreenHeight/2);
//        this.andando.addAnimation(10,true,8,13);
//
//        this.atirando = createSprite(R.mipmap.herosprite, 8,5);
//        this.atirando.setScreenPercent(20,25);
//        this.atirando.vrPosition.setX(AGScreenManager.iScreenWidth * 0.40f);
//        this.atirando.vrPosition.setY(AGScreenManager.iScreenHeight/2);
//        this.atirando.addAnimation(10,true,16,21);
//
//        this.pulando = createSprite(R.mipmap.herosprite, 8,5);
//        this.pulando.setScreenPercent(20,25);
//        this.pulando.vrPosition.setX(AGScreenManager.iScreenWidth * 0.55f);
//        this.pulando.vrPosition.setY(AGScreenManager.iScreenHeight/2);
//        this.pulando.addAnimation(5,true,24,26);
//
//        this.morendo = createSprite(R.mipmap.herosprite, 8,5);
//        this.morendo.setScreenPercent(20,25);
//        this.morendo.vrPosition.setX(AGScreenManager.iScreenWidth * 0.70f);
//        this.morendo.vrPosition.setY(AGScreenManager.iScreenHeight/2);
//        this.morendo.addAnimation(5,true,27,30);
//
//        this.abaixando = createSprite(R.mipmap.herosprite, 8,5);
//        this.abaixando.setScreenPercent(20,25);
//        this.abaixando.vrPosition.setX(AGScreenManager.iScreenWidth * 0.85f);
//        this.abaixando.vrPosition.setY(AGScreenManager.iScreenHeight/2);
//        this.abaixando.addAnimation(5,true,31,32);

        this.cachorrorun = createSprite(R.mipmap.hellrun, 5,1);
        this.cachorrorun.setScreenPercent(20,25);
        this.cachorrorun.vrPosition.setX(AGScreenManager.iScreenWidth * 0.85f);
        this.cachorrorun.vrPosition.setY(AGScreenManager.iScreenHeight * 0.10f);

        this.cachorrorun.addAnimation(5,true,0,4);


    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {

    }
}
