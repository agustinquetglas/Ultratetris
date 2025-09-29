package com.mycompany.app;
import org.junit.Test;
import static org.junit.Assert.*;

public class TetrisTest {

    @Test
    public void ColicionEntreDosObjetosTest(){
        Board board = new Board();
        PieceSquare pc = new PieceSquare();
        PieceSquare pc2 = new PieceSquare();
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
        PieceStick p1 = new PieceStick();
        p1.rotar("derecha"); // ponerlo horizontal
        p1.setX(0);
        p1.setY(19); // última fila
        board.fijarPieza(p1);

        // Segundo palo acostado
        PieceStick p2 = new PieceStick();
        p2.rotar("derecha");
        p2.setX(4);
        p2.setY(19);
        board.fijarPieza(p2);

        // Cuadrado que completa la fila
        PieceStick p5 = new PieceStick();
        p5.setX(8);
        p5.setY(16); // ocupa columna 8
        board.fijarPieza(p5);

        PieceStick p6 = new PieceStick();
        p6.setX(9);
        p6.setY(16); // ocupa columna 9
        board.fijarPieza(p6);

        // Limpiar y verificar
        int filas1 = board.limpiarFilasCompletas();
        assertEquals(1, filas1);
        assertEquals(1, board.getTotalFilasCompletadas());

        // Ahora otros dos palos para completar otra fila arriba
        PieceStick p3 = new PieceStick();
        p3.rotar("derecha");
        p3.setX(0);
        p3.setY(19);
        board.fijarPieza(p3);

        PieceStick p4 = new PieceStick();
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
            PieceStick p = new PieceStick();
            p.rotar("derecha"); // lo ponemos horizontal
            p.setX(0);
            p.setY(fila);
            board.fijarPieza(p);

            PieceStick p2 = new PieceStick();
            p2.rotar("derecha");
            p2.setX(4);
            p2.setY(fila);
            board.fijarPieza(p2);

        }

        PieceStick p3 = new PieceStick();
            p3.setX(0);
            p3.setY(8);
            board.fijarPieza(p3);

        PieceStick p4 = new PieceStick();
            p3.setX(0);
            p3.setY(8);
            board.fijarPieza(p4);

        PieceStick p5 = new PieceStick();
            p3.setX(0);
            p3.setY(8);
            board.fijarPieza(p5);

        PieceStick p6 = new PieceStick();
            p3.setX(0);
            p3.setY(8);
            board.fijarPieza(p6);

        // Intentamos colocar una nueva pieza en la parte superior
        PieceStick nueva = new PieceStick();
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

    @Test
    public void testGanarConCincoFilasCompletas() {
        Board board = new Board();
        Clock clock = new Clock();

        // Paso 1: llenar filas 16 a 19 con palos horizontales (col 0–7)
        for (int fila = 16; fila < 20; fila++) {
            PieceStick p1 = new PieceStick();
            p1.rotar("derecha");
            p1.setX(0);
            p1.setY(fila);
            board.fijarPieza(p1);

            PieceStick p2 = new PieceStick();
            p2.rotar("derecha");
            p2.setX(4);
            p2.setY(fila);
            board.fijarPieza(p2);
        }

        // Paso 2: llenar columnas 8 y 9 de filas 16 a 19 con palos verticales
        PieceStick p3 = new PieceStick(); // columna 8
        p3.setX(8);
        // simulamos su caída
        while (board.puedeBajar(p3)) {
            clock.tick(p3, board);
        }
        board.fijarPieza(p3);

        PieceStick p4 = new PieceStick(); // columna 9
        p4.setX(9);
        while (board.puedeBajar(p4)) {
            clock.tick(p4, board);
        }
        board.fijarPieza(p4);

        // Hasta acá filas 16–19 están llenas (4 filas completas)

        // Paso 3: colocar 5 cuadrados para completar fila 15
        for (int x = 0; x <= 8; x += 2) {
            PieceSquare cuadrado = new PieceSquare();
            cuadrado.setX(x);
            // simulamos la caída del cuadrado
            while (board.puedeBajar(cuadrado)) {
                clock.tick(cuadrado, board);
            }
            board.fijarPieza(cuadrado);
        }

        // Limpiar filas completas
        board.limpiarFilasCompletas();

        // Paso 4: verificamos que se completaron al menos 5 filas
        assertTrue("Debería haber completado al menos 5 filas", 
        board.getTotalFilasCompletadas() >= 5);
    }
}
