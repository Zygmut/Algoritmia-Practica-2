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
public class Pawn extends Piece {

    public Pawn() {
        super("sprite/pawn.png");
    }

    public ArrayList<int[]> getAttackingTiles(int[] piecePosition) {
        ArrayList<int[]> attackingTiles = new ArrayList<>();

       int[] temp = new int[2];
        // left 
        temp[0] = piecePosition[0] - 1;
        temp[1] = piecePosition[1] - 1;
        attackingTiles.add(temp);
        
        //right
        temp = new int[2];
        temp[0] = piecePosition[0] + 1;
        temp[1] = piecePosition[1] - 1;
        attackingTiles.add(temp);
        
        return attackingTiles;
    }
}
