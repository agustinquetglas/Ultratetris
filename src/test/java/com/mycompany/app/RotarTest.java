package com.mycompany.app;
import org.junit.Test;
import static org.junit.Assert.*;

public class RotarTest {

    @Test
    public void  Rotarpiezaderecha() {
        PieceT piezat1 = new PieceT();
        int[][] forma1 = piezat1.getForma();
        piezat1.rotar("derecha");
        int[][] forma2 = piezat1.getForma();
        assertNotEquals(forma1, forma2);
        assertEquals("0100011001000000", piezat1.matrizToString(forma2));
        
    }
    @Test
    public void  Rotarpiezaizquierda() {
        PieceT piezat1 = new PieceT();
        int[][] forma1 = piezat1.getForma();
        piezat1.rotar("izquierda");
        int[][] forma2 = piezat1.getForma();
        assertNotEquals(forma1, forma2);
        assertEquals("0000001001100010", piezat1.matrizToString(forma2));
        
    }
}

