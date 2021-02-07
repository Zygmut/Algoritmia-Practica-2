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
    private Piece piece; //la pieza que ocupa esta casilla
    private int pressureOnSpot; //la presion que sufre esta casilla. 0 significa libre de presion; mayor a 0 significa que hay al menos 1 atacante
    private final int[] position; //coordenadas de la casilla en el tablero
    
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

    public void setPressure(int pressureOnSpot) { //por si se quisiese resetear la presión
        this.pressureOnSpot = pressureOnSpot;
    }
    
    public void modifyPressure (boolean add){ //incrementa o decrementa la presion en la casilla 
        if(add){
            pressureOnSpot++;
        }else{
            pressureOnSpot--;
        }
    }
    
    
}
