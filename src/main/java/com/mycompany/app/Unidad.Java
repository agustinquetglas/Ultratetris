package com.mycompany.app;

public class Unidad{
    private int vida;
    public void setVida(int vida){
        this.vida = vida;
    }
    public int getVida(){
        return this.vida;
    }

    //Accion de Recibir Disparo
    public void Recibirdisparo (int daño){
        this.vida = this.vida - daño;
    }

    //Para verificar que eeste vivo
    public boolean estaVivo(){
        return this.vida > 0;
    }

    //Accion de disparar
    public void Disparar(Recibirdisparo objetivo){
        objetivo.Recibirdisparo(daño_base);
    }
}