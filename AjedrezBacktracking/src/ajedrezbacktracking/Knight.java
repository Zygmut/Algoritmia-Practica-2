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
public class Knight extends Piece {

    public Knight() {
        super("sprite/knight.png");
    }

    @Override
    public ArrayList<int[]> getAttackingTiles(int[] piecePosition, int boardDim) {
        ArrayList<int[]> attackingTiles = new ArrayList<>();

         int[] temp = new int[2];
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if ((i != 0) && (j != 0)) {     
                    if ((Math.abs(i) + Math.abs(j)) == 3) {
                        temp = new int[2];
                        temp[0] = piecePosition[0] + j;
                        temp[1] = piecePosition[1] + i;
                        attackingTiles.add(temp);
                    }
                }
            }
        }
        
        return attackingTiles;
    }
}
