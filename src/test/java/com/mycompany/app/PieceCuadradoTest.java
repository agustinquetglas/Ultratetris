package com.mycompany.app;
import org.junit.Test;
import static org.junit.Assert.*;

public class PieceCuadradoTest {

    @Test
    public void  cuadradoSeTransformaEnStringEsperado() {
        PieceCuadrado cuadrado1 = new PieceCuadrado();

        int[][] forma = cuadrado1.getForma();

        assertEquals("0000011001100000", cuadrado1.matrizToString(forma));
    }
}