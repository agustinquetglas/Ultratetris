package com.mycompany.app;
public class PieceL extends Piece {

    public PieceL() {
        super();
        formas = new int[4][4][4];

        // R0
        formas[0] = new int[][] {
            {0,0,0,0},
            {1,0,0,0},
            {1,1,1,0},
            {0,0,0,0}
        };

        // R90
        formas[1] = new int[][] {
            {0,1,1,0},
            {0,1,0,0},
            {0,1,0,0},
            {0,0,0,0}
        };

        // R180
        formas[2] = new int[][] {
            {1,1,1,0},
            {0,0,1,0},
            {0,0,0,0},
            {0,0,0,0}
        };

        // R270
        formas[3] = new int[][] {
            {0,1,0,0},
            {0,1,0,0},
            {1,1,0,0},
            {0,0,0,0}
        };
    }
}