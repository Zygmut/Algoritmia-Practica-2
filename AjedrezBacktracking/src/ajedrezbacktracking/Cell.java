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
    private int pressureOnSpot;
    private final int[] position;
    
    public Cell(int[] position){
        pressureOnSpot = 0;
        piece = null;
        this.position = position;
    }

    public int[] getPosition() {
        return position;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getPressureLevel() {
        return pressureOnSpot;
    }

    public void setPressure(int pressureOnSpot) {
        this.pressureOnSpot = pressureOnSpot;
    }
    
    public void modifyPressure (boolean add){
        if(add){
            pressureOnSpot++;
        }else{
            pressureOnSpot--;
        }
    }
    
    
}
