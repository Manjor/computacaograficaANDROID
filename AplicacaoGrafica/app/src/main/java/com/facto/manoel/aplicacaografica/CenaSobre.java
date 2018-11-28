package com.facto.manoel.aplicacaografica;

import com.facto.manoel.aplicacaografica.AndGraph.AGGameManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGInputManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGScene;
import com.facto.manoel.aplicacaografica.AndGraph.AGScreenManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSprite;

public class CenaSobre extends AGScene {


    private AGSprite fundo = null;
    private AGSprite fechar = null;

    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    public CenaSobre(AGGameManager pManager) {
        super(pManager);
    }


    @Override
    public void init() {


        this.fundo = createSprite(R.mipmap.telasobre,1,1);
        this.fundo.setScreenPercent(100,100);
        this.fundo.vrPosition.setXY(AGScreenManager.iScreenWidth/2,AGScreenManager.iScreenHeight/2);

        this.fechar = createSprite(R.mipmap.fechar,1,1);
        this.fechar.setScreenPercent(8,12);
        this.fechar.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.90f,AGScreenManager.iScreenHeight *0.90f);


    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        if(this.fechar.collide(AGInputManager.vrTouchEvents.getLastPosition())){
            vrGameManager.setCurrentScene(1);
        }
    }
}
