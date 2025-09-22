package com.mycompany.app;
public class Board {
    private int  largo = 10;
    private int ancho = 28;
    private int[][] board;

    public Board(){
        board= new int[largo][ancho];
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



    public void fijarPieza(Piece piece){
        int [][] forma = piece.getForma();
        int x = piece.getX();
        int y = piece.getY();

        for (int i = 0;i<4;i++ ){
            for(int j = 0;j<4;j++ ){
                if(forma[i][j]!=0){
                    int fila = y+i;
                    int col = x+j;
                    board[fila][col]=forma[i][j];
                }
            }
        }

    }

}


