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
public abstract class Piece {

    private final String imageURL;

    public Piece(String url) {
        imageURL = url;
    }

    public ArrayList<int[]> getAttackingTiles(int[] piecePosition) { //método que devuelve todas las posiciones que ataca la pieza desde una posición pasada por parámetro
        return null;
    }
    
    public ArrayList<int[]> getAttackingTiles(int[] piecePosition, int boardDim) { //método que devuelve todas las posiciones que ataca la pieza desde una posición pasada por parámetro
        return null;
    }

    public String getImageURL() {
        return imageURL;
    }
}
