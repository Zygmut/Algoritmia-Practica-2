/*
 * Clase Pieza
 */
package practica.pkg2;

/**
 *
 * @author Zygmut
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Piece {

    public static final String king = "sprite/king.png";
    public static final String queen = "sprite/queen.png";
    public static final String bishop = "sprite/bishop.png";
    public static final String knight = "sprite/knight.png";
    public static final String tower = "sprite/rook.png";
    public static final String pawn = "sprite/pawn.png";
    public static final String none = "sprite/none.png";

    public Image img;
    private String id;
    private int border;

    public Piece(String s, int Border) {
        this.border = Border;
        id = s.split("/")[1].split(".png")[0];

        img = new ImageIcon(s).getImage().getScaledInstance(Border, Border, java.awt.Image.SCALE_DEFAULT);  // Gets the image with path "s" and rescales it to a BorderxBorder resolution

    }
    
    void paintComponent(Graphics g, float x, float y) {
        g.drawImage(img, (int) x, (int) y, null);
    }

    public String getId() {
        return id;
    }
    
    public int getBorder(){ //Cheeky way to get Border into Cell, I'm lazy I know
        return border;
    }
}
