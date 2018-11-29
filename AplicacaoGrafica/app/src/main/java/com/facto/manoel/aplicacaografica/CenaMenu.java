package com.facto.manoel.aplicacaografica;

import com.facto.manoel.aplicacaografica.AndGraph.AGGameManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGInputManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGScene;
import com.facto.manoel.aplicacaografica.AndGraph.AGScreenManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSprite;

public class CenaMenu extends AGScene {


    AGGameManager gameManager = null;
    AGSprite telaFundo = null;
    AGSprite jogar = null;
    AGSprite sobre = null;
    AGSprite sair = null;

    CenaMenu(AGGameManager gameManager){
        super(gameManager);
        this.gameManager =gameManager;
    }
    @Override
    public void init() {

        telaFundo = createSprite(R.mipmap.inferno,1,1);
        telaFundo.setScreenPercent(100,100);
        telaFundo.vrPosition.setXY(AGScreenManager.iScreenWidth/2,AGScreenManager.iScreenHeight/2);

        this.jogar = createSprite(R.mipmap.btnjogar,1,1);
        this.jogar.setScreenPercent(50,25);
        this.jogar.vrPosition.setXY(AGScreenManager.iScreenWidth/2,AGScreenManager.iScreenHeight * 0.8f);

        this.sobre = createSprite(R.mipmap.btnsobre,1,1);
        this.sobre.setScreenPercent(50,25);
        this.sobre.vrPosition.setXY(AGScreenManager.iScreenWidth/2,AGScreenManager.iScreenHeight * 0.5f);

        this.sair = createSprite(R.mipmap.btnsair,1,1);
        this.sair.setScreenPercent(50,25);
        this.sair.vrPosition.setXY(AGScreenManager.iScreenWidth/2,AGScreenManager.iScreenHeight * 0.2f);

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
            if(jogar.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                gameManager.setCurrentScene(1);
                return;
            }
            if(sobre.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                gameManager.setCurrentScene(2);
                return;
            }
            if(sair.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                vrGameManager.vrActivity.finish();
            }
        }
    }
}
