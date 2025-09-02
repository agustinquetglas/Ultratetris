package com.mycompany.app;
public class Escudo {
    private boolean consumible = false;
    public boolean Activo() {
        return consumible;
    }

    public void Activar() {
        consumible = true;
        
    }

    public void aplicarEscudo(Peloton Peloton) {
        if (consumible) {
            Peloton.setVida(Peloton.getVida() + 100);
            consumible = false;
        }
    }
}
