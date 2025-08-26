package com.mycompany.app;

public class Unidad implements Recibirdisparo, Disparo {
    private int vida;
    public void setVida(int vida){
        this.vida = vida;
    }
    public int getVida(){
        return vida;
    }

    //Accion de Recibir Disparo
    public void recibirDisparo (int Danio){
        this.vida = this.vida - Danio;
    }

    //Para verificar que eeste vivo
    public boolean estaVivo(){
        return this.vida > 0;
    }

    //Accion de disparar
    public void Disparar(Recibirdisparo objetivo){
        objetivo.recibirDisparo(Disparo.Danio);
    }
}