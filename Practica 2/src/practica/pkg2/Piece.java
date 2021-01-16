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

    public static final String hormigaN = "sprite/hormiga_n.png";
    public static final String hormigaS = "sprite/hormiga_s.png";
    public static final String hormigaE = "sprite/hormiga_e.png";
    public static final String hormigaO = "sprite/hormiga_o.png";
    public static final String hoja = "sprite/hoja.png";
    public static final String nada = "sprite/nada.png";

    public static final String king = "sprite/king.png";
    public static final String queen = "sprite/queen.png";
    public static final String bishop = "sprite/bishop.png";
    public static final String knight = "sprite/knight.png";
    public static final String tower = "sprite/tower.png";
    public static final String pawn = "sprite/pawn.png";

    public Image img;
    private String id;

    public Piece(String s, int Border) {
        /**
         * Corta el string por "/", coge la segunda parte y la corta por el
         * punto y devuelve la primera parte. En el caso de sprite/hormiga_n.png
         * lo que haria seria separar sprite y luego separar.png , de esta
         * manera obteniendo hormiga_n
         */
        id = s.split("/")[1].split(".png")[0];

        try {
            Image temp = new ImageIcon(s).getImage();
            //img = ImageIO.read(new File(s));
            img = temp.getScaledInstance(Border, Border, java.awt.Image.SCALE_DEFAULT);

        } catch (Exception e) {
        }
    }

    void paintComponent(Graphics g, float x, float y) {
        g.drawImage(img, (int) x, (int) y, null);
    }

    public String getId() {
        return id;
    }
}
