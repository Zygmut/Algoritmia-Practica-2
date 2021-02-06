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
                if (playBoard[x][y].getPressureLevel() == 0) {
                    if (skip == 0) {
                        switch (piece) {
                            case 1:
                                playBoard[x][y].setPiece(new Queen());
                                break;
                            case 2:
                                playBoard[x][y].setPiece(new Rook());
                                break;
                            case 3:
                                playBoard[x][y].setPiece(new Bishop());
                                break;
                            case 4:
                                playBoard[x][y].setPiece(new BattleTower());
                                break;
                            case 5:
                                playBoard[x][y].setPiece(new Knight());
                                break;
                            case 6:
                                playBoard[x][y].setPiece(new King());
                                break;
                            case 7:
                                playBoard[x][y].setPiece(new Pawn());
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
        int[] pos = {x, y};
        ArrayList<int[]> attackingTiles = playBoard[x][y].getPiece().getAttackingTiles(pos);
        for (int[] i: attackingTiles ){
            if (playBoard[i[0]][i[1]].getPiece() != null) {
                playBoard[x][y].setPiece(null); //quitamos la pieza nueva del tablero
                return false;
            }
        }
        modifyPressure(attackingTiles, false);
        return true;
    }

    public boolean removeLastPiece() {
        if (movementHistory.isEmpty()) {
            return false;
        }
        Cell aux = movementHistory.get(movementHistory.size() - 1);
        ArrayList<int[]> attackingTiles = aux.getPiece().getAttackingTiles(aux.getPosition());
        modifyPressure(attackingTiles, true);
        movementHistory.remove(movementHistory.size() - 1);
        return true;
    }
    
    private void modifyPressure(ArrayList<int[]> attackingTiles, boolean security){
        for(int[] iterator : attackingTiles){
            playBoard[iterator[0]][iterator[1]].modifyPressure(security);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell[][] getPlayBoard() {
        return playBoard;
    }

}
