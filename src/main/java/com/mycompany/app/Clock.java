package com.mycompany.app;

public class Clock {
    private int timer = 0;
  
    public void tick(PieceBase piece , Board board) {
        setTimer();

        if (timer % 2 == 0) {
            // Sólo baja si es posible
            if (board.puedeBajar(piece)) {
                piece.bajarUnaFila();
            } else {
                // Si no puede bajar, se fija inmediatamente
                board.fijarPieza(piece);
            }
        }
    }

    private void setTimer() { timer++; }
    public int getTimer() { return timer; }
}