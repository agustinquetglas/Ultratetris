package com.mycompany.app;

import org.junit.Test;

public class AplicarescudoTest {
    @Test
    public void testAplicarEscudo() {
        Escudo escudo = new Escudo();
        Peloton soldado = new Soldado();


        // Activar el escudo
        escudo.Activar();
        assert escudo.Activo() : "El escudo debería estar activo después de activarlo.";

        // Aplicar el escudo al soldado
        int vidaInicialSoldado = soldado.getVida();
        escudo.aplicarEscudo(soldado);
        assert soldado.getVida() == vidaInicialSoldado + 100 : "El soldado debería haber recibido 100 puntos de vida.";
        assert !escudo.Activo() : "El escudo debería estar inactivo después de aplicarlo.";

    
    }
}
