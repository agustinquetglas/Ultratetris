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


    @Test
    public void ColicionEntreDosObjetosTest(){
        Board board = new Board();
        PieceCuadrado pc = new PieceCuadrado();
        PieceCuadrado pc2 = new PieceCuadrado();
        pc.setX(3);
        pc.setY(0);
        while (board.puedeBajar(pc)) {
            pc.bajarUnaFila();
        }
        board.fijarPieza(pc);
        int ypc=pc.getY();

        pc2.setX(3);
        pc2.setY(0);
        while(board.puedeBajar(pc2)){
            pc2.bajarUnaFila();
        }
        int ypc2=pc2.getY();

        assertEquals(ypc-2, ypc2);
        assertFalse(board.puedeBajar(pc2));
    }
    




}
