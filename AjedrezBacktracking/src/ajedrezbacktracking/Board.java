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
public class Board {

    private Cell playBoard[][]; //tablero de juego
    private ArrayList<Cell> movementHistory; //se guardan todas las piezas que se han ido colocando, por orden
    private final int width;
    private final int height;

    public Board(int width, int height) {
        playBoard = new Cell[width][height];
        movementHistory = new ArrayList<>();
        this.width = width;
        this.height = height;
    }

    public boolean putPiece(int piece, int skip) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (playBoard[x][y].isSafeSpot()) {
                    if (skip == 0) {
                        switch (piece) {
                            case 0:
                                playBoard[x][y].setPiece(new ); //necesita las clases de piezas
                                break;
                            case 1:
                                playBoard[x][y].setPiece(new );
                                break;
                            case 2:
                                playBoard[x][y].setPiece(new );
                                break;
                            case 3:
                                playBoard[x][y].setPiece(new );
                                break;
                            case 4:
                                playBoard[x][y].setPiece(new );
                                break;
                            case 5:
                                playBoard[x][y].setPiece(new );
                                break;
                            case 6:
                                playBoard[x][y].setPiece(new );
                                break;
                        }
                        if (isSafeToPlace(x, y)) {
                            movementHistory.add(playBoard[x][y]);
                            return true;
                        }
                    } else {
                        skip--;
                    }
                }
            }
        }
        return false;
    }

    private boolean isSafeToPlace(int x, int y) {
        /*Arraylist supongo*/  = playBoard[x][y].//getAttackingTiles;
        for (Cell iterator:/*Arraylist de arriba*/){
            if (iterator.getPiece() != null) {
                playBoard[x][y].setPiece(null); //quitamos la pieza nueva del tablero
                return false;
            }
        }
        return true;
    }

    public boolean removeLastPiece() {
        if (movementHistory.isEmpty()) {
            return false;
        }
        movementHistory.remove(movementHistory.size() - 1);
        return true;
    }

//    public void move(){
//        
//    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
