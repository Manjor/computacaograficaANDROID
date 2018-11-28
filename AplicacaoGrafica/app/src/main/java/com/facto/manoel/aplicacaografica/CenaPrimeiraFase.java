package com.facto.manoel.aplicacaografica;

import com.facto.manoel.aplicacaografica.AndGraph.AGGameManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGInputManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGScene;
import com.facto.manoel.aplicacaografica.AndGraph.AGScreenManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSprite;
import com.facto.manoel.aplicacaografica.AndGraph.AGTimer;

import java.util.ArrayList;

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
    AGSprite cachorrorun = null;
    AGSprite cachorroup = null;
    AGSprite telaPause = null;
    AGSprite pause = null;
    AGSprite bala = null;

    AGSprite banner = null;
    AGSprite sair = null;
    AGSprite resume = null;
    AGSprite som = null;

    AGTimer tempoRespawParado = null;
    AGTimer tempoTiro = null;
    AGTimer tempoRespawCachorro = null;
    AGTimer tempodeJogo = null;

    private ArrayList<AGSprite> balas = null;

    float balaX = 0;
    float cachorroX = 0;
    float balaposInicial = 0;
    float cachorroposInicial = 0;
    int i = 0;
    int j = 0;
    int direcao = 0;
    static int jogando = 0;

    int direcaoSom = 0;

    public CenaPrimeiraFase(AGGameManager pManager) {
        super(pManager);
        this.agGameManager = pManager;
    }

    @Override
    public void init() {

        //Determina o tempo de respawn do cachorro
        this.tempoRespawCachorro = new AGTimer(2000);
        this.tempoRespawParado = new AGTimer(1000);
        this.tempoTiro = new AGTimer(500);
        this.tempodeJogo = new AGTimer(1500);

        setSceneBackgroundColor(0.2f, 0.2f, 0.4f);

        //Define a imagem de Background da fase
        this.background = createSprite(R.mipmap.inferno, 1, 1);
        this.background.setScreenPercent(100, 100);
        this.background.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);


        //Define o sprite do personagem
        this.parado = createSprite(R.mipmap.herosprite, 8, 5);
        this.parado.setScreenPercent(20, 25);
        this.parado.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.10f, AGScreenManager.iScreenHeight * 0.10f);

        //Define as animações que o personagem terá
        this.parado.addAnimation(15, true, 0, 7);
        this.parado.addAnimation(5, false, 32, 33);
        this.parado.addAnimation(10, false, 26, 29);
        this.parado.addAnimation(10, false, 0, 1);

        //Instancia o array de balas e carrega o sprite na imagem
//        balas = new ArrayList<>();
//        createSprite(R.mipmap.bullet,1,1).bVisible = false;

        this.cachorrorun = createSprite(R.mipmap.hellway, 12, 1);
        this.cachorrorun.setScreenPercent(20, 25);
        this.cachorrorun.vrPosition.setX(AGScreenManager.iScreenWidth * 0.85f);
        this.cachorrorun.vrPosition.setY(AGScreenManager.iScreenHeight * 0.10f);
        this.cachorroposInicial = cachorrorun.vrPosition.getX();
        this.cachorrorun.addAnimation(10, true, 0, 11);
        this.cachorrorun.addAnimation(10, false, 0, 1);
//
//        this.cachorroup = createSprite(R.mipmap.hellup, 6,1);
//        this.cachorroup.setScreenPercent(20,25);
//        this.cachorroup.vrPosition.setX(AGScreenManager.iScreenWidth * 0.85f);
//        this.cachorroup.vrPosition.setY(AGScreenManager.iScreenHeight * 0.10f);
//        this.cachorroposInicial = cachorroup.vrPosition.getX();
//        this.cachorroup.addAnimation(10,true,0,5);
//
        this.bala = createSprite(R.mipmap.bullet, 1, 1);
        this.bala.setScreenPercent(5, 10);
        this.bala.vrPosition.setX(parado.vrPosition.getX() + (parado.getSpriteWidth() / 2) + (bala.getSpriteWidth() / 3));
        this.bala.vrPosition.setY(parado.vrPosition.getY() + (parado.getSpriteHeight() / 6));
//
        this.balaposInicial = bala.vrPosition.getX();
        this.bala.bVisible = false;
//        this.cachorrorun.addAnimation(10,true,0,11);
//        ArrayList<AGSprite> spritesCachorro = new ArrayList<>();
//
//        spritesCachorro.add(cachorrorun);
//        spritesCachorro.add(cachorroup);
        this.som = createSprite(R.mipmap.som, 3, 1);
        this.som.setScreenPercent(8, 10);
        this.som.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.80f, AGScreenManager.iScreenHeight * 0.90f);

        this.som.addAnimation(60, false, 0, 1);
        this.som.addAnimation(60, false, 0, 2);

        this.telaPause = createSprite(R.mipmap.fundomenu, 1, 1);
        this.telaPause.setScreenPercent(90, 70);
        this.telaPause.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);
        this.telaPause.bVisible = false;

        this.pause = createSprite(R.mipmap.pausa, 1, 1);
        this.pause.setScreenPercent(8, 10);
        this.pause.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.90f, AGScreenManager.iScreenHeight * 0.90f);


        this.banner = createSprite(R.mipmap.bannerhellway,1,1);
        this.banner.setScreenPercent(60,15);
        this.banner.vrPosition.setXY(telaPause.vrPosition.getX(), telaPause.vrPosition.getY() * 1.6f);
        this.banner.bVisible = false;

        this.resume = createSprite(R.mipmap.btnretornar, 1, 1);
        this.resume.setScreenPercent(60, 15);
        this.resume.vrPosition.setXY(telaPause.vrPosition.getX(), telaPause.vrPosition.getY() * 1.2f);
        this.resume.bVisible = false;

        this.sair = createSprite(R.mipmap.btnsair, 1, 1);
        this.sair.setScreenPercent(60, 15);
        this.sair.vrPosition.setXY(telaPause.vrPosition.getX(), telaPause.vrPosition.getY() * 0.80f);
        this.sair.bVisible = false;


    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    int valocidade = 20;

    @Override
    public void loop() {
        if (jogando == 0) {
            gerenciaPersonagem();
            atirar();
            gerenciaCachorro();
            balaX += i;
            cachorroX += j;
            bala.vrPosition.setX(bala.vrPosition.getX() + balaX);
            this.bala.vrPosition.fX += i;
            this.cachorrorun.vrPosition.fX -= j;
            //cachorrorun.vrPosition.setX(cachorrorun.vrPosition.getX() - cachorroX);
        }
        gerenciaSom();
        gerenciaPausa();
    }

    /**
     * Gerencia os movimentos do personagem
     */
    private void gerenciaPersonagem() {

//        if (AGInputManager.vrTouchEvents.screenDragged()) {
//            if (this.direcao == 1) {
//                this.parado.setCurrentAnimation(0);
//                this.direcao = 0;
//            } else {
//                this.parado.setCurrentAnimation(1);
//                this.direcao = 1;
//            }
//        }

        if (this.parado.bVisible == false) {
            this.tempoRespawParado.update();
        }
        if (this.tempoRespawParado.isTimeEnded()) {
            this.parado.setCurrentAnimation(0);
            this.parado.bVisible = true;
        }
    }

    public void atirar() {
        tempoTiro.update();
        if (!tempoTiro.isTimeEnded()) {
            return;
        }
        if (AGInputManager.vrTouchEvents.screenClicked() &&
                !pause.collide(AGInputManager.vrTouchEvents.getLastPosition()) &&
                !som.collide(AGInputManager.vrTouchEvents.getLastPosition()) &&
                !som.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
            tempoTiro.restart();
            bala.bVisible = true;
            this.bala.vrPosition.fX = balaposInicial;
            i = 2;
            balaX = 0;
        }
        if (bala.vrPosition.getX() >= (AGScreenManager.iScreenWidth + 10)) {
            i = 0;
            balaX = 0;
            bala.bVisible = false;
            this.bala.vrPosition.fX = balaposInicial;
            //this.bala.vrPosition.setX(this.balaposInicial);
        }
    }

    public void gerenciaCachorro() {

        if (bala.collide(cachorrorun) && bala.bVisible == true && cachorrorun.bVisible == true) {
            this.cachorrorun.bVisible = false;
            this.bala.bVisible = false;
            this.cachorrorun.vrPosition.setX(this.cachorroposInicial);
            this.j = 0;
            cachorroX = 0;
        }
        if (cachorrorun.bVisible == false) {
            this.tempoRespawCachorro.update();
            if (this.tempoRespawCachorro.isTimeEnded()) {
                this.cachorrorun.bVisible = true;
                this.tempoRespawCachorro.restart();
            }
        }
        if (cachorrorun.bVisible == true) {
            j = 20;
            //this.bala.bVisible = false;
        }
//        if(tempoRespawParado.isTimeEnded() && parado.getCurrentAnimationIndex() == 2){
//            this.tempoRespawParado.reiniciar();
//            parado.bVisible = false;
//            parado.setCurrentAnimation(0);
//            parado.bVisible = true;
//        }
        if (cachorrorun.collide(parado) && parado.bVisible == true) {
            tempoRespawParado.update();
            parado.setCurrentAnimation(2);
            this.parado.bVisible = false;
        }
        if (this.cachorrorun.vrPosition.getX() <= (-20)) {
            this.cachorrorun.bVisible = false;
            this.cachorrorun.vrPosition.setX(this.cachorroposInicial);
            this.j = 0;
            this.cachorroX = 0;
        }
    }

    public void gerenciaPausa() {

        if (this.pause.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
            jogando = 1;
            //this.pause.bVisible = false;
            this.parado.setCurrentAnimation(3);
            this.cachorrorun.setCurrentAnimation(1);
            this.telaPause.bVisible = true;
            this.sair.bVisible = true;
            this.resume.bVisible = true;
            this.banner.bVisible = true;
        }
        if (this.resume.collide(AGInputManager.vrTouchEvents.getLastPosition()) && this.resume.bVisible == true) {
            jogando = 0;
            this.parado.setCurrentAnimation(0);
            this.cachorrorun.setCurrentAnimation(0);
            this.telaPause.bVisible = false;
            this.sair.bVisible = false;
            this.resume.bVisible = false;
            this.banner.bVisible = false;
        }
        if(this.sair.collide(AGInputManager.vrTouchEvents.getLastPosition()) && this.sair.bVisible == true){
            vrGameManager.setCurrentScene(0);
        }
    }

    public void gerenciaSom() {

        if (this.som.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
            this.direcaoSom++;
            if(this.direcaoSom > 1){
                this.direcaoSom = 0;
            }
            this.som.setCurrentAnimation(this.direcaoSom);
        }
    }

}
