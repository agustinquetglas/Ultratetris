package com.mycompany.app;
import org.junit.Test;
import static org.junit.Assert.*;

public class RotarTest {

    @Test
    public void rotarPiezaderecha() {
        PieceT piezat1 = new PieceT();
        piezat1.rotar("derecha");
        assertEquals("0100011001000000", piezat1.matrizToString(piezat1.getForma()));
    }

    @Test
    public void rotarPiezaizquierda() {
        PieceT piezat1 = new PieceT();
        piezat1.rotar("izquierda");
        assertEquals("0000001001100010", piezat1.matrizToString(piezat1.getForma()));
    }


    @Test
    public void rotarLPiezaDerecha() {
        PieceL l = new PieceL();
        l.rotar("derecha");
        assertEquals("0110010001000000", l.matrizToString(l.getForma()));
    }

    @Test
    public void rotarLPiezaIzquierda() {
        PieceL l = new PieceL();
        l.rotar("izquierda");
        assertEquals("0000001000100110", l.matrizToString(l.getForma()));
    }

    @Test
    public void rotarLinvertidoDerecha() {
        PieceLinvertido li = new PieceLinvertido();
        li.rotar("derecha");
        assertEquals("0000010001000110", li.matrizToString(li.getForma()));
    }

    @Test
    public void rotarLinvertidoIzquierda() {
        PieceLinvertido li = new PieceLinvertido();
        li.rotar("izquierda");
        assertEquals("0110001000100000", li.matrizToString(li.getForma()));
    }

    @Test
    public void rotarDogLDerecha() {
        PieceDogL dog = new PieceDogL();
        dog.rotar("derecha");
        assertEquals("0010011001000000", dog.matrizToString(dog.getForma()));
    }

    @Test
    public void rotarDogRIzquierda() {
        PieceDogR dogr = new PieceDogR();
        dogr.rotar("izquierda");
        assertEquals("0000010001100010", dogr.matrizToString(dogr.getForma()));
    }

    @Test
    public void rotarPaloDerecha() {
        PiecePalo pd = new PiecePalo();
        pd.rotar("derecha");
        assertEquals("1111000000000000", pd.matrizToString(pd.getForma()));
    }

    @Test
    public void rotarPaloIzquierda() {
        PiecePalo pi = new PiecePalo();
        pi.rotar("izquierda");
        assertEquals("0000000000001111", pi.matrizToString(pi.getForma()));
    }


}

