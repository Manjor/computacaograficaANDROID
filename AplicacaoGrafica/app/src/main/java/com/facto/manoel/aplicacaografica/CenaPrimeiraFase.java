package com.facto.manoel.aplicacaografica;

import com.facto.manoel.aplicacaografica.AndGraph.AGGameManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGInputManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGScene;
import com.facto.manoel.aplicacaografica.AndGraph.AGScreenManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSoundManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSprite;
import com.facto.manoel.aplicacaografica.AndGraph.AGTimer;

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
    AGSprite bala = null;
    float balaX = 0;
    float cachorroX = 0;
    float balaposInicial = 0;
    float cachorroposInicial = 0;
    AGTimer tempoRespawCachorro = null;

    public CenaPrimeiraFase(AGGameManager pManager) {
        super(pManager);
        this.agGameManager = pManager;
    }

    @Override
    public void init() {

        this.tempoRespawCachorro =  new AGTimer(2000);
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

        this.cachorrorun = createSprite(R.mipmap.hellway, 12,1);
        this.cachorrorun.setScreenPercent(20,25);
        this.cachorrorun.vrPosition.setX(AGScreenManager.iScreenWidth * 0.85f);
        this.cachorrorun.vrPosition.setY(AGScreenManager.iScreenHeight * 0.10f);
        this.cachorroposInicial = cachorrorun.vrPosition.getX();

        this.cachorrorun.addAnimation(10,true,0,11);
        this.bala = createSprite(R.mipmap.bullet, 1,1);
        this.bala.setScreenPercent(5,10);
        this.bala.vrPosition.setX(parado.vrPosition.getX() + (parado.getSpriteWidth() / 2) + (bala.getSpriteWidth() / 3));
        this.bala.vrPosition.setY(parado.vrPosition.getY() + (parado.getSpriteHeight() / 6));

        this.balaposInicial =  bala.vrPosition.getX();
        this.bala.bVisible = false;
        //this.cachorrorun.addAnimation(10,true,0,11);
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }
    int i = 0;
    int j = 0;
    @Override
    public void loop() {

        if(bala.vrPosition.getX() >= (AGScreenManager.iScreenWidth + 20)) {
            i = 0;
            balaX = 0;
            bala.bVisible = false;
            this.bala.vrPosition.setX(this.balaposInicial);
        }
        if(AGInputManager.vrTouchEvents.screenClicked() && bala.bVisible == false ){
            bala.bVisible = true;
            i = 2;
            balaX = 0;
        }
        if(bala.collide(cachorrorun) && bala.bVisible == true){
            this.cachorrorun.bVisible = false;
            this.bala.bVisible = false;
            this.cachorrorun.vrPosition.setX(this.cachorroposInicial);
            this.j = 0;
            cachorroX = 0;
        }

        if(cachorrorun.bVisible == false){
            this.tempoRespawCachorro.update();
            if(this.tempoRespawCachorro.isTimeEnded()){
                this.cachorrorun.bVisible = true;
                this.tempoRespawCachorro.restart();
            }
        }
        if(cachorrorun.bVisible == true){
            j = 2;
        }
        if(cachorrorun.collide(parado)){

        }
        if(this.cachorrorun.vrPosition.getX() <= (-20)){
            this.cachorrorun.bVisible = false;
            this.cachorrorun.vrPosition.setX(this.cachorroposInicial);
            this.j = 0;
            this.cachorroX = 0;
        }
        cachorroX += j;
        balaX+= i;
        bala.vrPosition.setX(bala.vrPosition.getX() + balaX);
        cachorrorun.vrPosition.setX(cachorrorun.vrPosition.getX() - cachorroX);
    }
}
