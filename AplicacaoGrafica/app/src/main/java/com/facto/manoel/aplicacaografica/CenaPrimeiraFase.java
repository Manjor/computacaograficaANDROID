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
    AGSprite personagem = null;
    AGSprite cachorro = null;
    AGSprite fundoPause = null;
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

    float balaX = 0;
    float cachorroX = 0;
    float balaposInicial = 0;
    float cachorroposInicial = 0;
    int i = 0;
    int j = 0;
    static int jogando = 0;

    int somtiro;

    int direcaoSom = 0;
    int velocidade = 30;

    int vidas = 0;

    public CenaPrimeiraFase(AGGameManager pManager) {
        super(pManager);
        this.agGameManager = pManager;
    }

    @Override
    public void init() {
        vidas = 3;

        AGSoundManager.vrMusic.loadMusic("musicafundo.mp3",true);
        AGSoundManager.vrMusic.play();
        somtiro = AGSoundManager.vrSoundEffects.loadSoundEffect("somtiro.mp3");

        //Determina o tempo de respawn do cachorro
        this.tempoRespawCachorro = new AGTimer(2000);
        this.tempoRespawParado = new AGTimer(1000);
        this.tempoTiro = new AGTimer(500);
        this.tempodeJogo = new AGTimer(10000);

        setSceneBackgroundColor(0.2f, 0.2f, 0.4f);

        //Define a imagem de Background da fase
        this.background = createSprite(R.mipmap.inferno, 1, 1);
        this.background.setScreenPercent(100, 100);
        this.background.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);


        //Define o sprite do personagem
        this.personagem = createSprite(R.mipmap.herosprite, 8, 5);
        this.personagem.setScreenPercent(20, 25);
        this.personagem.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.10f, AGScreenManager.iScreenHeight * 0.10f);

        //Define as animações que o personagem terá
        this.personagem.addAnimation(15, true, 0, 7);
        this.personagem.addAnimation(5, false, 32, 33);
        this.personagem.addAnimation(10, false, 26, 29);
        this.personagem.addAnimation(10, false, 0, 1);


        this.cachorro = createSprite(R.mipmap.hellway, 12, 1);
        this.cachorro.setScreenPercent(20, 25);
        this.cachorro.vrPosition.setX(AGScreenManager.iScreenWidth * 0.85f);
        this.cachorro.vrPosition.setY(AGScreenManager.iScreenHeight * 0.10f);
        this.cachorroposInicial = cachorro.vrPosition.getX();
        this.cachorro.addAnimation(10, true, 0, 11);

        this.bala = createSprite(R.mipmap.bullet, 1, 1);
        this.bala.setScreenPercent(5, 10);
        this.bala.vrPosition.setX(personagem.vrPosition.getX() + (personagem.getSpriteWidth() / 2) + (bala.getSpriteWidth() / 3));
        this.bala.vrPosition.setY(personagem.vrPosition.getY() + (personagem.getSpriteHeight() / 6));
        this.balaposInicial = bala.vrPosition.getX();
        this.bala.bVisible = false;

        this.som = createSprite(R.mipmap.som, 3, 1);
        this.som.setScreenPercent(8, 10);
        this.som.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.80f, AGScreenManager.iScreenHeight * 0.90f);

        this.som.addAnimation(60, false, 0, 1);
        this.som.addAnimation(60, false, 0, 2);

        this.fundoPause = createSprite(R.mipmap.fundomenu, 1, 1);
        this.fundoPause.setScreenPercent(90, 70);
        this.fundoPause.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);
        this.fundoPause.bVisible = false;

        this.pause = createSprite(R.mipmap.pausa, 1, 1);
        this.pause.setScreenPercent(8, 10);
        this.pause.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.90f, AGScreenManager.iScreenHeight * 0.90f);

        this.banner = createSprite(R.mipmap.bannerhellway,1,1);
        this.banner.setScreenPercent(60,15);
        this.banner.vrPosition.setXY(fundoPause.vrPosition.getX(), fundoPause.vrPosition.getY() * 1.6f);
        this.banner.bVisible = false;

        this.resume = createSprite(R.mipmap.btnretornar, 1, 1);
        this.resume.setScreenPercent(60, 15);
        this.resume.vrPosition.setXY(fundoPause.vrPosition.getX(), fundoPause.vrPosition.getY() * 1.2f);
        this.resume.bVisible = false;

        this.sair = createSprite(R.mipmap.btnsair, 1, 1);
        this.sair.setScreenPercent(60, 15);
        this.sair.vrPosition.setXY(fundoPause.vrPosition.getX(), fundoPause.vrPosition.getY() * 0.80f);
        this.sair.bVisible = false;


        jogando = 0;
        this.personagem.setCurrentAnimation(0);
        this.cachorro.setCurrentAnimation(0);
        this.fundoPause.bVisible = false;
        this.sair.bVisible = false;
        this.resume.bVisible = false;
        this.banner.bVisible = false;


    }

    @Override
    public void restart() {
        init();
    }

    @Override
    public void stop() {

    }

    int valocidade = 10;

    @Override
    public void loop() {

        tempodeJogo.update();
        if(tempodeJogo.isTimeEnded()){
            velocidade *=2;
            if(velocidade >200){
                velocidade = 20;
            }
            tempodeJogo.restart();
        }
        if(vidas < 1){
            agGameManager.setCurrentScene(3);
            return;
        }
        if (jogando == 0) {
            gerenciaPersonagem();
            atirar();
            gerenciaCachorro();
            balaX += i;
            cachorroX += j;
            bala.vrPosition.setX(bala.vrPosition.getX() + balaX);
            this.bala.vrPosition.fX += i;
            this.cachorro.vrPosition.fX -= j;
        }
        gerenciaSom();
        gerenciaPausa();
    }

    /**
     * Gerencia os movimentos do personagem
     */
    private void gerenciaPersonagem() {


        if (this.personagem.bVisible == false) {
            this.tempoRespawParado.update();
        }
        if (this.tempoRespawParado.isTimeEnded()) {
            this.personagem.setCurrentAnimation(0);
            this.personagem.bVisible = true;
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
                !som.collide(AGInputManager.vrTouchEvents.getLastPosition()) &&
                bala.bVisible == false) {

            AGSoundManager.vrSoundEffects.play(somtiro);
            tempoTiro.restart();
            bala.bVisible = true;
            this.bala.vrPosition.fX = balaposInicial;
            i = 10;
            balaX = 0;
        }
        if (bala.vrPosition.getX() >= (AGScreenManager.iScreenWidth + 10)) {
            i = 0;
            balaX = 0;
            bala.bVisible = false;
            this.bala.vrPosition.fX = balaposInicial;
        }
    }

    public void gerenciaCachorro() {

        if (bala.collide(cachorro) && bala.bVisible == true && cachorro.bVisible == true) {
            this.cachorro.bVisible = false;
            this.bala.bVisible = false;
            this.cachorro.vrPosition.setX(this.cachorroposInicial);
            this.j = 0;
            cachorroX = 0;
        }
        if (cachorro.bVisible == false) {
            this.tempoRespawCachorro.update();
            if (this.tempoRespawCachorro.isTimeEnded()) {
                this.cachorro.bVisible = true;
                this.tempoRespawCachorro.restart();
            }
        }
        if (cachorro.bVisible == true) {
            j = velocidade;
        }
        if (cachorro.collide(personagem) && personagem.bVisible == true) {
            tempoRespawParado.update();
            vidas -= 1;
            personagem.setCurrentAnimation(2);
            this.personagem.bVisible = false;
        }
        if (this.cachorro.vrPosition.getX() <= (-20)) {
            this.cachorro.bVisible = false;
            this.cachorro.vrPosition.setX(this.cachorroposInicial);
            this.j = 0;
            this.cachorroX = 0;
        }
    }

    public void gerenciaPausa() {

        if (this.pause.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
            jogando = 1;
            //this.pause.bVisible = false;
            this.personagem.setCurrentAnimation(3);
            this.cachorro.setCurrentAnimation(1);
            this.fundoPause.bVisible = true;
            this.sair.bVisible = true;
            this.resume.bVisible = true;
            this.banner.bVisible = true;
        }
        if (this.resume.collide(AGInputManager.vrTouchEvents.getLastPosition()) && this.resume.bVisible == true) {
            jogando = 0;
            this.personagem.setCurrentAnimation(0);
            this.cachorro.setCurrentAnimation(0);
            this.fundoPause.bVisible = false;
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
            AGSoundManager.vrMusic.stop();
            if(this.direcaoSom > 1){
                this.direcaoSom = 0;
            }
            this.som.setCurrentAnimation(this.direcaoSom);
        }
    }

}
