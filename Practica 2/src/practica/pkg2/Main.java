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

  public void start(){
  new Window().setVisible(true);
  }
	
	

    public static void main(String[] args) {

         Main m = new Main();
		 m.start();
 

            
      
    }

}
