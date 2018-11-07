package com.facto.manoel.aplicacaografica;

import com.facto.manoel.aplicacaografica.AndGraph.AGGameManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGScene;
import com.facto.manoel.aplicacaografica.AndGraph.AGScreenManager;
import com.facto.manoel.aplicacaografica.AndGraph.AGSprite;
import com.facto.manoel.aplicacaografica.AndGraph.AGTimer;


public class CenaAbertura extends AGScene
{
    AGTimer tempo = null;
    AGSprite nanatsu = null;

    CenaAbertura(AGGameManager gameManager){
        super(gameManager);
    }

    /**
     * Metodo que irá sera chamado toda vez que a cena for ativada
     * Sempre que a cena for exibida*/
    @Override
    public void init() {

        tempo = new AGTimer(3000);
        //Cria uma referencia de imagem e realiza os cortes de tamanho
        nanatsu = createSprite(R.mipmap.nanatsu, 1,1);
        //Definir a posição da imagem na tela
        nanatsu.vrPosition.setX(AGScreenManager.iScreenWidth /2);
        nanatsu.vrPosition.setY(AGScreenManager.iScreenHeight /2);
        //Define a porcentagem da tela que a imagem irá ocupar
        nanatsu.setScreenPercent(40, 30);
        //Configura o background da cena
        setSceneBackgroundColor(1,1,0);
    }

    /**
     * Metodo chamado sempre que o aplicativo retorna de uma interrupção do sistema
     * Ex.: Chamada telefónica*/
    @Override
    public void restart() {

    }

    /**
     * Chamado quando uma interrupção ocorre
     * */
    @Override
    public void stop() {

    }

    /**
     * Chamado N vezes por segundo, semelhante ao (onDrawFrame)
     * */
    @Override
    public void loop() {
        //Adiciona uma fração de tempo ao tempo da cena
        tempo.update();
        //verifica se o tempo ja acabou
        if(tempo.isTimeEnded()){
            //Variável de referencia do super vrGameManager
            //seta qual o indice da tela a qual quer realizar a troca
            vrGameManager.setCurrentScene(1);
        }

    }



}
