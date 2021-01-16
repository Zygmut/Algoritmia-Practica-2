/*
 * Administracion del tablero 
 */
package practica.pkg2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

/**
 *
 * @author Zygmut
 */
public class Board extends JPanel {

    private Integer Dim;        // Number of cells per roll (also column tho)
    private Integer Max;        // Dimension of the frame
    private Integer Border;     // Dimension of each cell
    private Cell cBoard[][];    // Contents of the matrix

    /*
     * Board constructor
     * @param dim Dimension of the board where dim is the number of elements 
     * per row and column
     */
    public Board(int dim) {
        this.Dim = dim;
        this.Max = 800;
        this.Border = Max / Dim;

        cBoard = new Cell[Dim][Dim];
        
        populate();

    }

    /*
     * Fills the matrix with shit IDK
     * Debug purposes, obv
     */
    private void populate(){
        int y = 0;
        for (int i = 0; i < Dim; i++) {
            int x = 0;
            for (int j = 0; j < Dim; j++) {
                Rectangle2D.Float rec = new Rectangle2D.Float(x, y, Border, Border);
                cBoard[i][j] = new Cell(rec);
                cBoard[i][j].setPiece(new Piece(Piece.pawn, Border));  // Codigo para insertar una pieza en posicion i j
                x += Border;
            }
            y += Border;
        }
    }
    
    /*
     * Does this really need a commentary
     */
    public void addPiece(Piece piece, int xpos, int ypos) {
        cBoard[ypos][xpos].setPiece(piece); 
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < Dim; i++) {
            for (int j = 0; j < Dim; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(new Color(227, 206, 167));   // Light color
                } else {
                    g.setColor(new Color(166, 126, 91));    // Dark color
                }
                g.fillRect(j * Border, i * Border, Border, Border);
                cBoard[i][j].paintcomponent(g);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Max, Max);
    }

}
