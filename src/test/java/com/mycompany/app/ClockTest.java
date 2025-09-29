package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClockTest {
        @Test
    public void timerIncrementaEnCadaTick() {
        Clock clock = new Clock();
        Board board = new Board();
        PieceStick piece = new PieceStick();
        int ContadorTimer = clock.getTimer();
        clock.tick(piece, board);
        assertEquals(ContadorTimer + 1, clock.getTimer());
    }
}
