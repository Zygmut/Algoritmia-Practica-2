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
public class King extends Piece {

    public King() {
        super("sprite/king.png");
    }

    @Override
    public ArrayList<int[]> getAttackingTiles(int[] piecePosition, int boardDim) {
        ArrayList<int[]> attackingTiles = new ArrayList<>();

        for (int i = -1; i < 2; i++) { // y
            for (int j = -1; j < 2; j++) { // x
                if ((j != 0) && (i != 0)) { // I want to avoid problems like " he can kill himself"
                    int[] temp = {piecePosition[0] + i, piecePosition[1] + j};
                    attackingTiles.add(temp);
                }
            }
        }
        return attackingTiles;
    }
}
