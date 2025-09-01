package com.mycompany.app;

import org.junit.Test;

public class AplicarescudoTest {
    @Test
    public void testAplicarEscudo() {
        Soldado soldado = new Soldado();
        Tanque tanque = new Tanque();
        Escudo escudo = new Escudo();
        soldado.setEscudo(escudo);
        tanque.Disparar(soldado);
        assert(soldado.getVida() == 100);
        tanque.Disparar(soldado);
        assert(soldado.getVida() == 0);
        
    }
}
