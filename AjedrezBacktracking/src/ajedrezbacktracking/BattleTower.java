/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrezbacktracking;

import java.util.ArrayList;

/**
 *
 * @author Daxmaster
 */
public class BattleTower extends Piece {

    public BattleTower() {
        super("sprite/battletower.png");
    }

    public ArrayList<int[]> getAttackingTiles(int[] piecePosition, int boardDim) {
        ArrayList<int[]> attackingTiles = new ArrayList<>();

        int[] temp;
        for (int i = -2; i <= 2; i++) {         // y
            if (Math.abs(i) == 2) {             // Bordes superior e inferior
                for (int j = -2; j <= 2; j++) {     // x
                    temp = new int[2];
                    temp[0] = piecePosition[0] + j;
                    temp[1] = piecePosition[1] + i;
                    attackingTiles.add(temp);
                }
            } else {                            // Bordes laterales 
                temp = new int[2];
                temp[0] = piecePosition[0] - 2;
                temp[1] = piecePosition[1] + i;
                attackingTiles.add(temp);

                temp = new int[2];
                temp[0] = piecePosition[0] + 2;
                temp[1] = piecePosition[1] + i;
                attackingTiles.add(temp);
            }

        }

        return attackingTiles;
    }
}
