/*
 * Clase Celda
 */
package practica.pkg2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author Zygmut
 */
public class Cell {

    private ArrayList<int[]> attackingTiles = new ArrayList<>();
    private int[] pos = new int[2];
    private Piece piece; // Data structura that hold the image, basically

    public Cell(Piece piece) {
        this.piece = piece;

    }

    public Cell(Piece piece, int x, int y) {
        pos[0] = x;
        pos[1] = y;
        this.piece = piece;
    }
    
   

    /*
     * Returns an array with all the attacking positions this cell has, depending on
     * the piece
     */
    public ArrayList<int[]> getAttackingPositions() {

        int[] piecePosition = {pos[0] / piece.getBorder(), pos[1] / piece.getBorder()}; // Actual position of this
        // cell in the matrix,
        // remember, [i = y | j = x ]
        int boardDim = 800 / piece.getBorder(); // Max/Border. So, hoy many pieces are per row

        switch (piece.getId()) {
            case "queen":
                queenMoveset(piecePosition, boardDim);
                break;
            case "king":
                kingMoveset(piecePosition);
                break;
            case "rook":
                rookMoveset(piecePosition, boardDim);
                break;
            case "bishop":
                bishopMoveset(piecePosition, boardDim);
                break;
            case "knight":
                knightMoveset(piecePosition);
                break;
            case "pawn":
                pawnMoveset(piecePosition);
                break;
            case "battletower":
                battleTowerMoveset(piecePosition);
                break;
        }
        return attackingTiles;
    }

    private void kingMoveset(int[] piecePosition) {
        attackingTiles.clear();

        for (int i = -1; i < 2; i++) { // y
            for (int j = -1; j < 2; j++) { // x
                if ((j != 0) && (i != 0)) { // I want to avoid problems like " he can kill himself"
                    int[] temp = {piecePosition[0] + i, piecePosition[1] + j};
                    attackingTiles.add(temp);
                }
            }
        }
    }

    private void queenMoveset(int[] piecePosition, int boardDim) {
        attackingTiles.clear();
        ArrayList temp = new ArrayList();
        bishopMoveset(piecePosition, boardDim);
        temp.addAll(attackingTiles);

        rookMoveset(piecePosition, boardDim);
        attackingTiles.addAll(temp);
    }

    private void rookMoveset(int[] piecePosition, int boardDim) {
        attackingTiles.clear();
        int[] temp = new int[2];
        for (int i = 1; i < boardDim; i++) {
            // If a vector has any negative number, is OUT OF BOUNDS. We could remove those 
            // or just throw a try catch statement to try to acces that position in the matrix
            // if it breaks, just skip that one
            
            // Fucking end this. This is retarded
            // left & right
            temp = new int[2];
            temp[0] = piecePosition[0] - i;
            temp[1] = piecePosition[1];
            attackingTiles.add(temp);

            temp = new int[2];
            temp[0] = piecePosition[0] + i;
            temp[1] = piecePosition[1];
            attackingTiles.add(temp);

            // up & down
            temp = new int[2];
            temp[0] = piecePosition[0];
            temp[1] = piecePosition[1] - i;
            attackingTiles.add(temp);

            temp = new int[2];
            temp[0] = piecePosition[0];
            temp[1] = piecePosition[1] + i;
            attackingTiles.add(temp);
   
        }
    }

    private void bishopMoveset(int[] piecePosition, int boardDim) {
        attackingTiles.clear();
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

    }

    private void knightMoveset(int[] piecePosition) {
        attackingTiles.clear();
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

    }

    private void pawnMoveset(int[] piecePosition) {
        attackingTiles.clear();
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
    }

    private void battleTowerMoveset(int[] piecePosition) {
        attackingTiles.clear();
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

    }

    public void paintcomponent(Graphics g) {
        // Graphics2D g2d = (Graphics2D) g;
        piece.paintComponent(g, pos[0], pos[1]);
        // g2d.setColor(Color.BLACK); //Nasty rectange border color
        // g2d.draw(rec);
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

}
