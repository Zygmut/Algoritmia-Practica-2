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
public class Board {
    
    Cell playBoard[][];
    
    public Board(int width, int  height){
        playBoard = new Cell[width][height];
    }
    
    public boolean putPiece(int piece){
        //for(){   recorremos tablero hasta encontrar la primera posicion "segura"
            //marcamos todas las casillas que ahora estaran siendo atacadas. Si ataca a una pieza, sigue buscando una casilla
            //para revisar las casillas siendo atacadas, tenemos que crear la pieza. Hay que eliminar la pieza en el caso de que no se pueda poner
                //en caso de exito, return true
        //}
        //return false
    }
    
//    public void move(){
//        
//    }
    
}
