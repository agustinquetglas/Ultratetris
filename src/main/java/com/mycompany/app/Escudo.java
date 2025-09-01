package com.mycompany.app;
public class Escudo {
    private boolean consumible = false;
    public boolean Activo() {
        return consumible;
    }

    public void Activar() {
        consumible = true;
        
    }

    public void aplicarEscudo(Unidad unidad) {
        if (consumible) {
            unidad.setVida(unidad.getVida() + 100);
            consumible = false;
        }
    }
}
