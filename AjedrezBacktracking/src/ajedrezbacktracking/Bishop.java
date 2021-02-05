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

    public Bishop(String url) {
        super("sprite/bishop.png", 1);
    }

    public ArrayList<int[]> getAttackingTiles(int[] piecePosition, int boardDim) {
        ArrayList<int[]> attackingTiles = new ArrayList<>();

       int[] temp = new int[2];
        for (int i = 1; i < boardDim; i++) {
            // If a vector has any negative number, is OUT OF BOUNDS. We could remove those 
            // or just throw a try catch statement to try to acces that position in the matrix
            // if it breaks, just skip that one
            // The solution of the first proposal might be the following code snippet
            //
            // if(Arrays.stream(temp).filter(h -> h < 0).toArray().length > 0){
            //     System.out.println("yo, this is out of bounds");
            // }else{
            //     attackingTiles.add(temp);
            // }
            //
            // Where the condition is true if there is any negative number within temp
            // Tho this is very interesting, a try catch might be a lot more faster 
            // As we are working with error control and not array analysis shenannigans
            
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
