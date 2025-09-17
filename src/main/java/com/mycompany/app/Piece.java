package com.mycompany.app;

public abstract class Piece {
    protected int[][][] formas;

    public int[][] getForma() {
        return formas[0]; // devuelve la orientación 0
    }

    public String matrizToString(int[][] m) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                sb.append(m[i][j]);
            }
        }
        return sb.toString();
    }
}