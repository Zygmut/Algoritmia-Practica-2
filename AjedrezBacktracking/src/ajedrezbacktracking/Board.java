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
    private final int width; //amplitud
    private final int height; //altura

    public Board(int width, int height) {
        playBoard = new Cell[width][height];
        for(int i = 0 ; i < width ; i++){
            for(int j = 0 ; j < height ; j++){
                int[] position = {i, j};
                playBoard[i][j] = new Cell(position);
            }
        }
        movementHistory = new ArrayList<>();
        this.width = width;
        this.height = height;
    }

    public boolean putPiece(int piece, int skip) { //intenta colocar la pieza deseada en una posicion libre
        for (int x = 0; x < width; x++) { //recorrido del tablero
            for (int y = 0; y < height; y++) {
                if (playBoard[x][y].getPressureLevel() == 0 && playBoard[x][y].getPiece() == null) { //comprueba si hay una pieza en esa posicion y si esa posicion está siendo atacada
                    if (skip == 0) { //skip sirve para saltar posiciones validas, quizás esta posición ya fue revisada en una iteración anterior y no dió buenos resultados
                        switch (piece) {
                            case 0:
                                playBoard[x][y].setPiece(new Queen());
                                break;
                            case 1:
                                playBoard[x][y].setPiece(new Rook());
                                break;
                            case 2:
                                playBoard[x][y].setPiece(new Bishop());
                                break;
                            case 3:
                                playBoard[x][y].setPiece(new BattleTower());
                                break;
                            case 4:
                                playBoard[x][y].setPiece(new Knight());
                                break;
                            case 5:
                                playBoard[x][y].setPiece(new King());
                                break;
                            case 6:
                                playBoard[x][y].setPiece(new Pawn());
                                break;
                        }
                        if (isNotAttacking(x, y)) { //comprueba que la pieza nueva no esté atacando a ninguna otra pieza ya colocada
                            movementHistory.add(playBoard[x][y]); //la colocación ha tenido exito y se guarda la casilla de la pieza nueva en el historial
                            return true;
                        }
                    } else {
                        skip--; //la casilla era buena, pero se fuerza la continuación del bucle y se decrementa la variable.
                    }
                }
            }
        }
        return false; //no se pudo poner la pieza en ningun sitio
    }

    private boolean isNotAttacking(int x, int y) {
        int[] pos = {x, y}; 
        ArrayList<int[]> attackingTiles = playBoard[x][y].getPiece().getAttackingTiles(pos, height); //cogemos todas las casillas que están siendo atacadas por la pieza objetivo
        for (int[] i: attackingTiles ){ 
            try{
            if (playBoard[i[0]][i[1]].getPiece() != null) { //comprueba que esté apuntando a otra pieza
                playBoard[x][y].setPiece(null); //quitamos la pieza nueva del tablero
                return false;
            }
            }catch(ArrayIndexOutOfBoundsException e){
            }
        }
        modifyPressure(attackingTiles, true); //la pieza no ataca a nadie, pero está aplicando presion a otras casillas. Asi que aqui modificamos la presión para marcarlas como no seguras
        return true;
    }

    public boolean removeLastPiece() { //elimina la ultima pieza que fue colocada
        if (movementHistory.isEmpty()) { //control de errores
            return false;
        }
        Cell aux = movementHistory.get(movementHistory.size() - 1); //cogemos la ultima casilla ocupada
        ArrayList<int[]> attackingTiles = aux.getPiece().getAttackingTiles(aux.getPosition(), height); //cogemos las casillas que estaban siendo atacadas por esta pieza
        modifyPressure(attackingTiles, false); //decrementamos la presion en dichas casillas
        aux.setPiece(null); //eliminamos la pieza de la casilla
        movementHistory.remove(movementHistory.size() - 1); //eliminamos la casilla del historial
        return true;
    }
    
    private void modifyPressure(ArrayList<int[]> attackingTiles, boolean security){
        for(int[] iterator : attackingTiles){
            try{
            playBoard[iterator[0]][iterator[1]].modifyPressure(security); //incrementa (security = true) o decrementa (security = false) la presion
            }catch(ArrayIndexOutOfBoundsException e){
            }
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
