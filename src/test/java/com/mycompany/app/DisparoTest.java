package com.mycompany.app;
import org.junit.Test;
import static org.junit.Assert.*;

public class DisparoTest {
    @Test
    public void testSoldadoDisparo() {
        Soldado soldado = new Soldado();
        Tanque tanque = new Tanque();
        soldado.Disparar(tanque);
        assertEquals(100, tanque.getVida());
         soldado.Disparar(tanque);
        assertEquals(0, tanque.getVida());
    }
}
