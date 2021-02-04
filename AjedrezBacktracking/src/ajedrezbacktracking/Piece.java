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
public class Piece {
    private final String image;
    private final int value;
    
    public Piece(String url, int value){
        image = url;
        this.value = value;
    }
    
}
