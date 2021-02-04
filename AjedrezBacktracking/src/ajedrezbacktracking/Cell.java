/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrezbacktracking;

/**
 *
 * @author Daxmaster
 */
public class Cell {
    private Piece piece;
    private boolean safeSpot;
    
    public Cell(){
        safeSpot = true;
        piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isSafeSpot() {
        return safeSpot;
    }

    public void setSafeSpot(boolean safeSpot) {
        this.safeSpot = safeSpot;
    }
    
    
}
