package com.mycompany.app;

public class Escudo {
    private boolean activo = true; // arranca disponible

    // aplica el escudo y devuelve el daño que debe afectar
    public int aplicarEscudo(Unidad unidad, int danio) {
        return (activo) 
            ? consumir(unidad)     // si activo → se consume
            : danio;               // si no activo → aplica daño normal
    }

    private int consumir(Unidad unidad) {
        activo = false;                  // se consume
        return 0;                        // bloquea el daño
    }
}