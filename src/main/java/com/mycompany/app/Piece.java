package com.mycompany.app;

public abstract class Piece {
    protected int[][][] formas;

    public int[][] getForma() {
        return formas[0]; // devuelve la orientación 0
    }

   public void rotar(String direccion) {
        if (direccion.equals("derecha")) {
            // Rotación hacia la derecha
            int[][] nuevaForma = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    nuevaForma[i][j] = formas[0][3-j][i];  // Rotación 90 grados (sentido horario)
                }
            }
            formas[0] = nuevaForma;
        } else if (direccion.equals("izquierda")) {
            // Rotación hacia la izquierda
            int[][] nuevaForma = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    nuevaForma[i][j] = formas[0][j][3-i];  // Rotación 90 grados (sentido antihorario)
                }
            }
            formas[0] = nuevaForma;
        }
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