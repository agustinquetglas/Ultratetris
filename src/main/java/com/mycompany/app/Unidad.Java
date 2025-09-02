package com.mycompany.app;

public abstract class Peloton implements Recibirdisparo, Disparo {
    private int vida;
    private Escudo escudo;
    public void setVida(int vida){
        this.vida = vida;
    }
    public int getVida(){
        return vida;
    }

    //Getter y Setter del Escudo
    public void setEscudo(Escudo escudo){
        this.escudo = escudo;
    }

    public Escudo getEscudo(){
        return escudo;
    }

    //Accion de Recibir Disparo
    public void recibirDisparo(int Danio){
        if (escudo != null && escudo.Activo()) {
            escudo.aplicarEscudo(this);
        } else {
            this.vida -= Danio;
        }
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