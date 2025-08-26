package com.mycompany.app;
import org.junit.Test;

public class VidaTest {
    @Test
    public void testSoldadoVida() {
        Soldado soldado = new Soldado();
        assert(soldado.getVida() == 100);
    }
    
    @Test
    public void testTanqueVida() {
        Tanque tanque = new Tanque();
        assert(tanque.getVida() == 200);
    }

    @Test
    public void testBuqueVida() {
        Buque buque = new Buque();
        assert(buque.getVida() == 300);
    }

}
