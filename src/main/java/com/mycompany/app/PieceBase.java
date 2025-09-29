package com.mycompany.app;

public abstract class PieceBase {
    protected int[][][] formas;
    protected int x = 3;   
    protected int y = 0;   

    public int[][] getForma() {
        return formas[0]; 
    }

   public void rotar(String direccion) {
        if (direccion.equals("derecha")) {
         
            int[][] nuevaForma = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    nuevaForma[i][j] = formas[0][3-j][i];  
                }
            }
            formas[0] = nuevaForma;
        } else if (direccion.equals("izquierda")) {
          
            int[][] nuevaForma = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    nuevaForma[i][j] = formas[0][j][3-i];  
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

   
    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

   
    public void bajarUnaFila() {
        y++;
    }

}