package com.mycompany.app;

public class Board {
    private int ancho = 10;   // columnas
    private int largo = 20;   // filas
    private int[][] board;

    private int totalFilasCompletadas = 0; // contador acumulado

    public Board() {
        board = new int[largo][ancho];
    }

    public int[][] getBoard() {
    return board;
}

    public boolean puedeBajar(Piece piece) {
        int[][] forma = piece.getForma();
        int x = piece.getX();
        int y = piece.getY();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (forma[i][j] != 0) {
                    int fila = y + i + 1;
                    int col = x + j;

                    if (fila >= largo) return false;         
                    if (board[fila][col] != 0) return false;  
                }
            }
        }
        return true;
    }

    public void fijarPieza(Piece piece) {
        int [][] forma = piece.getForma();
        int x = piece.getX();
        int y = piece.getY();

        for (int i = 0; i < 4; i++ ) {
            for (int j = 0; j < 4; j++ ) {
                if (forma[i][j] != 0) {
                    int fila = y + i;
                    int col = x + j;
                    board[fila][col] = forma[i][j];
                }
            }
        }
    }

    public int limpiarFilasCompletas() {
        int filasEliminadas = 0;
        for (int i = 0; i < largo; i++) {
            boolean completa = true;
            for (int j = 0; j < ancho; j++) {
                if (board[i][j] == 0) {
                    completa = false;
                    break;
                }
            }
            if (completa) {
                filasEliminadas++;
                // bajamos todas las filas que están arriba
                for (int k = i; k > 0; k--) {
                    board[k] = board[k - 1].clone();
                }
                board[0] = new int[ancho]; // creamos una nueva fila vacía en la parte superior
            }
        }
        totalFilasCompletadas += filasEliminadas;
        return filasEliminadas;
    }

    public int getTotalFilasCompletadas() {
        return totalFilasCompletadas;
    }
}
