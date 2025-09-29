package com.mycompany.app;
import org.junit.Test;
import static org.junit.Assert.*;

public class PiecesTest {

   
    @Test
    public void testCuadradoInicial() {
        PieceSquare cuadrado = new PieceSquare();
        assertEquals("0000110011000000", cuadrado.matrizToString(cuadrado.getForma()));
    }


    @Test
    public void testDogLInicial() {
        PieceDogL dogl = new PieceDogL();
        assertEquals("0000110001100000", dogl.matrizToString(dogl.getForma()));
    }

    @Test
    public void testDogRInicial() {
        PieceDogR dogr = new PieceDogR();
        assertEquals("0000011011000000", dogr.matrizToString(dogr.getForma()));
    }


    @Test
    public void testLInicial() {
        PieceL l = new PieceL();
        assertEquals("0000100011100000", l.matrizToString(l.getForma()));
    }

    @Test
    public void testLinvertidoInicial() {
        PieceLinvertido li = new PieceLinvertido();
        assertEquals("0000000101110000", li.matrizToString(li.getForma()));
    }


    @Test
    public void testPaloInicial() {
        PieceStick palo = new PieceStick();
        assertEquals("1000100010001000", palo.matrizToString(palo.getForma()));
    }

    @Test
    public void testTInicial() {
        PieceT t = new PieceT();
        assertEquals("0000010011100000", t.matrizToString(t.getForma()));
    }
}

