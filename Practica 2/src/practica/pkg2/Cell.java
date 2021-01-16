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
            case "tower":
                towerMoveset(piecePosition, boardDim);
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
            case "xxx":
                xxxMoveset(piecePosition);
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

        towerMoveset(piecePosition, boardDim);
        attackingTiles.addAll(temp);
    }

    private void towerMoveset(int[] piecePosition, int boardDim) {
        attackingTiles.clear();
        
        
        for (int i = 0; i < 10; i++) {
            
        }
    }

    private void bishopMoveset(int[] piecePosition, int boardDim) {
        attackingTiles.clear();

    }

    private void knightMoveset(int[] piecePosition) {
        attackingTiles.clear();

    }

    private void pawnMoveset(int[] piecePosition) {
        attackingTiles.clear();

    }

    private void xxxMoveset(int[] piecePosition) {
        attackingTiles.clear();

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
