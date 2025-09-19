package com.mycompany.app;
import org.junit.Test;
import static org.junit.Assert.*;

public class CaidalibreTest {
    @Test
    public void CaidaCuadradoL(){
        Board board = new Board();
        Clock clock = new Clock();
        PieceCuadrado pc = new PieceCuadrado();
        PieceL pl = new PieceL();

        // Simulación de 60 ticks
        for (int i = 0; i < 60; i++) {
            // Piezas bajan si pueden
            if (board.puedeBajar(pc)) clock.tick(pc);

            if (board.puedeBajar(pl)) clock.tick(pl);
        }
        // Verificamos que ambas piezas estén dentro del tablero
        assertTrue(pc.getY() + 2 <= 28); // cuadrado tiene altura 2
        assertTrue(pl.getY() + 3 <= 28);        // L tiene altura 3

        // Verificamos que las piezas no bajen más allá del límite
        assertFalse(board.puedeBajar(pc));
        assertFalse(board.puedeBajar(pl));

    }
}
