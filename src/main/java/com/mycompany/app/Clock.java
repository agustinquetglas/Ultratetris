package com.mycompany.app;

public class Clock {
    private int timer = 0;
  
    public void tick(Piece piece , Board board) {
        setTimer();

        if (timer % 2 == 0) {
            piece.bajarUnaFila();
        }else{
            board.fijarPieza(piece);
        }
    }

    private void setTimer() { timer++; }
    public int getTimer() { return timer; }
}