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
    AGSprite sonic = null;
    public CenaPrimeiraFase(AGGameManager pManager) {
        super(pManager);
        this.agGameManager = pManager;
    }

    @Override
    public void init() {
        setSceneBackgroundColor(0.2f,0.2f,0.4f);
        this.sonic = createSprite(R.mipmap.sonic,27,10);
        this.sonic.setScreenPercent(10,15);
        this.sonic.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        this.sonic.vrPosition.setY(AGScreenManager.iScreenHeight/2);
        this.sonic.addAnimation(10,true,0,5);
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
