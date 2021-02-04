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
public class King extends Piece{
    
    private final int value = 1;
    private final String id = "King";
    
    public King(String url){
        super(url, value);
    }
    
}
