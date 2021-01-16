/*
 * Clase Principal del programa
 */
package practica.pkg2;

import javax.swing.JFrame;

/**
 *
 * @author Zygmut
 */
public class Main extends JFrame {

    Board board;

    public Main() {
        this.board = new Board(8);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main frame = new Main();
                frame.setTitle("Practica 2: Las piezas que no se matan entre ellas");
                frame.setResizable(false);
                frame.setSize(frame.board.getPreferredSize());
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(frame.board);
                frame.pack();
                

                frame.setVisible(true);
                frame.invalidate();
                frame.revalidate();
                frame.repaint();

            }
        });
    }

}
