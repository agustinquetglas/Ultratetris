package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTest {  
     @Test
    public void formatoTablero() {
        Board board = new Board();
        int[][] m = board.getBoard();
        assertEquals(20, m.length);
        assertEquals(10, m[0].length);   

        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 10; j++)
                assertEquals(0, m[i][j]);
    }
    
    @Test
    public void CaidaCuadradoL(){
        Board board = new Board();
        Clock clock = new Clock();
        PieceSquare pc = new PieceSquare();
        PieceL pl = new PieceL();

        // Simulación de 4000 ticks para verificar que no sale del tablero
        for (int i = 0; i < 4000; i++) {
            // Piezas bajan si pueden
            if (board.puedeBajar(pc)) clock.tick(pc,board);

            if (board.puedeBajar(pl)) clock.tick(pl , board);
        }
        // Verificamos que ambas piezas estén dentro del tablero
        assertTrue(pc.getY() + 2 <= 28); // cuadrado tiene altura 2
        assertTrue(pl.getY() + 3 <= 28);        // L tiene altura 3

        // Verificamos que las piezas no bajen más allá del límite
        assertFalse(board.puedeBajar(pc));
        assertFalse(board.puedeBajar(pl));

    }

}
