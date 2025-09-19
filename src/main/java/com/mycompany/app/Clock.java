package com.mycompany.app;

public class Clock {
    private int timer = 0;
    // Tick del reloj: incrementa y baja la pieza cuando sea par
    public void tick(Piece piece) {
        setTimer();

        if (timer % 2 == 0) {
            piece.bajarUnaFila();
        }
    }

    private void setTimer() { timer++; }
    public int getTimer() { return timer; }
}