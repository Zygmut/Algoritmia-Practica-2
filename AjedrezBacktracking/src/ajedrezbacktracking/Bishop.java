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
public class Bishop extends Piece {

    public Bishop() {
        super("sprite/bishop.png");
    }

    @Override
    public ArrayList<int[]> getAttackingTiles(int[] piecePosition, int boardDim) {
        ArrayList<int[]> attackingTiles = new ArrayList<>();

       int[] temp = new int[2];
        for (int i = 1; i < boardDim; i++) {
            
            // \ line
            temp = new int[2];
            temp[0] = piecePosition[0] - i;
            temp[1] = piecePosition[1] - i;
            attackingTiles.add(temp);

            temp = new int[2];
            temp[0] = piecePosition[0] + i;
            temp[1] = piecePosition[1] + i;
            attackingTiles.add(temp);

            // / line
            temp = new int[2];
            temp[0] = piecePosition[0] + i;
            temp[1] = piecePosition[1] - i;
            attackingTiles.add(temp);

            temp = new int[2];
            temp[0] = piecePosition[0] - i;
            temp[1] = piecePosition[1] + i;
            attackingTiles.add(temp);
   
        }
        return attackingTiles;
    }
}
