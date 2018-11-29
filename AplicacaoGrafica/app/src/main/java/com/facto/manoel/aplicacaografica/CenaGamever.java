package com.facto.manoel.aplicacaografica;

import com.facto.manoel.aplicacaografica.AndGraph.AGGameManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGInputManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGScene;
import com.facto.manoel.aplicacaografica.AndGraph.AGScreenManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSprite;

public class CenaGamever extends AGScene {


    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/

    AGSprite fundo = null;
    AGSprite fechar = null;
    AGGameManager gameManager;
    public CenaGamever(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {
        fundo = createSprite(R.mipmap.gameover,1,1);
        fundo.setScreenPercent(100,100);
        fundo.vrPosition.setXY(AGScreenManager.iScreenWidth/2,AGScreenManager.iScreenHeight/2);

        fechar = createSprite(R.mipmap.fechar,1,1);
        fechar.setScreenPercent(8,12);
        fechar.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.90f,AGScreenManager.iScreenHeight *0.90f);
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {

        if(AGInputManager.vrTouchEvents.screenClicked()){
            if(fechar.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                vrGameManager.setCurrentScene(0);
                return;
            }
        }

    }
}
