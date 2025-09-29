package com.mycompany.app;

public class PieceSquare extends PieceBase {
    public PieceSquare() {
        super();
        formas = new int[4][4][4];

        formas[0] = new int[][] {
            {0,0,0,0},
            {1,1,0,0},
            {1,1,0,0},
            {0,0,0,0}
        };
        formas[1] = new int[][] {
            {0,0,0,0},
            {0,1,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };
        formas[2] = new int[][] {
            {0,0,0,0},
            {0,1,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };
        formas[3] = new int[][] {
            {0,0,0,0},
            {0,1,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };
      
    }
}