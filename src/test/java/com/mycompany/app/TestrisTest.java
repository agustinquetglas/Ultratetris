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
    
    

    @Test
    public void testContarFilasCompletadas() {
        Board board = new Board();

        // Primer palo acostado
        PiecePalo p1 = new PiecePalo();
        p1.rotar("derecha"); // ponerlo horizontal
        p1.setX(0);
        p1.setY(19); // última fila
        board.fijarPieza(p1);

        // Segundo palo acostado
        PiecePalo p2 = new PiecePalo();
        p2.rotar("derecha");
        p2.setX(4);
        p2.setY(19);
        board.fijarPieza(p2);

        // Cuadrado que completa la fila
        PiecePalo p5 = new PiecePalo();
        p5.setX(8);
        p5.setY(16); // ocupa columna 8
        board.fijarPieza(p5);

        PiecePalo p6 = new PiecePalo();
        p6.setX(9);
        p6.setY(16); // ocupa columna 9
        board.fijarPieza(p6);

        // Limpiar y verificar
        int filas1 = board.limpiarFilasCompletas();
        assertEquals(1, filas1);
        assertEquals(1, board.getTotalFilasCompletadas());

        // Ahora otros dos palos para completar otra fila arriba
        PiecePalo p3 = new PiecePalo();
        p3.rotar("derecha");
        p3.setX(0);
        p3.setY(19);
        board.fijarPieza(p3);

        PiecePalo p4 = new PiecePalo();
        p4.rotar("derecha");
        p4.setX(4);
        p4.setY(19);
        board.fijarPieza(p4);

        int filas2 = board.limpiarFilasCompletas();
        assertEquals(1, filas2);
        assertEquals(2, board.getTotalFilasCompletadas());
    }
    
    @Test
    public void testGameOver() {
        Board board = new Board();

        // Llenamos el tablero fila por fila con palos horizontales
        for (int fila = 0; fila < 20; fila++) {
            PiecePalo p = new PiecePalo();
            p.rotar("derecha"); // lo ponemos horizontal
            p.setX(0);
            p.setY(fila);
            board.fijarPieza(p);

            PiecePalo p2 = new PiecePalo();
            p2.rotar("derecha");
            p2.setX(4);
            p2.setY(fila);
            board.fijarPieza(p2);

        }

        PiecePalo p3 = new PiecePalo();
            p3.setX(0);
            p3.setY(8);
            board.fijarPieza(p3);

        PiecePalo p4 = new PiecePalo();
            p3.setX(0);
            p3.setY(8);
            board.fijarPieza(p4);

        PiecePalo p5 = new PiecePalo();
            p3.setX(0);
            p3.setY(8);
            board.fijarPieza(p5);

        PiecePalo p6 = new PiecePalo();
            p3.setX(0);
            p3.setY(8);
            board.fijarPieza(p6);

        // Intentamos colocar una nueva pieza en la parte superior
        PiecePalo nueva = new PiecePalo();
        nueva.setX(3);
        nueva.setY(0);

        // Verificamos que no se puede fijar porque está lleno
        boolean puedeEntrar = true;
        int[][] forma = nueva.getForma();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (forma[i][j] != 0) {
                    int fila = nueva.getY() + i;
                    int col = nueva.getX() + j;
                    if (board.getBoard()[fila][col] != 0) {
                        puedeEntrar = false;
                    }
                }
            }
        }

        assertFalse("El tablero está lleno, debería ser game over", puedeEntrar);
    }


        
   
}
