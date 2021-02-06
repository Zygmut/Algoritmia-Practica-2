/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrezbacktracking;

import javax.swing.JOptionPane;

/**
 *
 * @author Daxmaster
 */
public class AjedrezBacktracking {

    /**
     * @param args the command line arguments
     */
    private final GraphicDisplay output;
    private Board board;

    public static void main(String[] args) {
        new AjedrezBacktracking().begin();

    }

    public AjedrezBacktracking() {
        output = new GraphicDisplay();
		
    }

    public void begin() {
        int input[] = output.mainMenu();
        //devolverá un array de ints, donde cada int representa la cantidad de una cierta pieza
        board = new Board(input[0], input[0]);
        int pieces[] = getSliceOfArray(input, 1, input.length);
        //call to the algorithm
        if(backtracking(pieces)){
            System.out.println("Solución encontrada");
             output.Tablero(board);
        }else{
			
            System.out.println("No se ha encontrado solución");
			JOptionPane.showMessageDialog(null, "No se ha encontrado solución", "Shark Mentality", JOptionPane.PLAIN_MESSAGE);
			 System.exit(0); 
            //output.Failure();
        }
        
    }

    public int[] getSliceOfArray(int[] arr, int start, int end) {
        int[] slice = new int[end - start];
        for (int i = 0; i < slice.length; i++) {
            slice[i] = arr[start + i];
        }
        return slice;
    }

    public boolean backtracking(int pieces[]) {
        for (int i = 0; i < pieces.length; i++) { //este for solo funciona hasta que se encuentra una pieza que se deba poner
            if (pieces[i] != 0) {
                pieces[i]--;
                for (int j = 0; j < board.getHeight() + board.getWidth(); j++) { //este for asegura que, en caso de fallo al poner la pieza, se revisen las demás casillas hasta la totalidad del tablero
                    if (board.putPiece(i, j)) { //se ha conseguido poner la pieza
                        if(backtracking(pieces)){ //las siguientes llamadas consiguen poner pieza
                            return true;
                        } //las siguientes llamadas no consiguen poner pieza, por lo que se tiene que buscar otra casilla para la pieza que fue colocada
                        board.removeLastPiece();
                    } else { //no se ha conseguido poner la pieza
                        pieces[i]++;
                        return false;
                    }
                }
                return false; //a este caso solo llega la primera llamada del método, donde despues de probar en todo el tablero sin conseguir que funcione se sale del bucle sin más
            }
        }
        return true; //caso trivial, aqui solo se llega cuando no quedan piezas por poner del array.
    }

}
