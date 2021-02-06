/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrezbacktracking;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Daxmaster
 */
public class GraphicDisplay extends JPanel {

    int[] UserInput = new int[8];

    public int[] mainMenu() {
        JFrame MainMenu = new JFrame("Main Menu");
        MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu.setSize(200, 300);
        JPanel Panel = new JPanel();
        JTextField QueenTextField = new JTextField("0", 2);
        JTextField RookTextField = new JTextField("0", 2);
        JTextField PawnTextField = new JTextField("0", 2);
        JTextField BishopTextField = new JTextField("0", 2);
        JTextField KnightTextField = new JTextField("0", 2);
        JTextField KingTextField = new JTextField("0", 2);
        JTextField BattleTowerTextField = new JTextField("0", 2);
        JTextField SizeOfBoardTextField = new JTextField("1", 2);

        JLabel QueenJlable2 = new JLabel("How many queens:");
        JLabel RookJlable2 = new JLabel("How many rooks:");
        JLabel PawnJlable2 = new JLabel("How many pawns:");
        JLabel BishopJlable2 = new JLabel("How many bishops:");
        JLabel KnightJlable2 = new JLabel("How many knights:");
        JLabel KingJlable2 = new JLabel("How many kings:");
        JLabel BattleTowerJlable2 = new JLabel("How many battle towers:");
        JLabel SizeOfBoardJlable = new JLabel("Size of the board");

        JButton Accept = new JButton("Accept");
        Accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {

                UserInput[0] = Integer.parseInt(SizeOfBoardTextField.getText());
                UserInput[1] = Integer.parseInt(QueenTextField.getText());
                UserInput[2] = Integer.parseInt(RookTextField.getText());
                UserInput[3] = Integer.parseInt(BishopTextField.getText());
                UserInput[4] = Integer.parseInt(BattleTowerTextField.getText());
                UserInput[5] = Integer.parseInt(KnightTextField.getText());
                UserInput[6] = Integer.parseInt(KingTextField.getText());
                UserInput[7] = Integer.parseInt(PawnTextField.getText());
                boolean Check_User = true;
                for (int i = 0; i < 7 && Check_User; i++) {
                    if (UserInput[i] < 0) {
                        Check_User = false;

                    }
                }
                if (Check_User) {
                    MainMenu.setVisible(false);
                }

            }
        });

        Panel.add(QueenJlable2);
        Panel.add(QueenTextField);

        Panel.add(RookJlable2);
        Panel.add(RookTextField);

        Panel.add(PawnJlable2);
        Panel.add(PawnTextField);

        Panel.add(BishopJlable2);
        Panel.add(BishopTextField);

        Panel.add(KnightJlable2);
        Panel.add(KnightTextField);

        Panel.add(KingJlable2);
        Panel.add(KingTextField);

        Panel.add(BattleTowerJlable2);
        Panel.add(BattleTowerTextField);

        Panel.add(SizeOfBoardJlable);
        Panel.add(SizeOfBoardTextField);
        Panel.add(Accept);

        MainMenu.add(Panel);
        MainMenu.setVisible(true);
        MainMenu.setLocationRelativeTo(null);
        while (MainMenu.isVisible() == true) {
            System.out.println("");
        }

        return UserInput;

    }
    Board Tablero;

    public void Tablero(Board Tablero) {
        this.Tablero = Tablero;
        JFrame Window = new JFrame("Respuesta Final");
        Window.setSize(640, 676);
        Window.setResizable(false);
        Window.setVisible(true);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window.setLocationRelativeTo(null);
        Window.add(this);
        Window.invalidate();
        Window.revalidate();
        Window.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        int Border = 640 / Tablero.getHeight();
        for (int i = 0; i < Tablero.getHeight(); i++) {
            for (int j = 0; j < Tablero.getWidth(); j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(new Color(227, 206, 167));
                } else {
                    g.setColor(new Color(166, 126, 91));
                }
                g.fillRect(j * Border, i * Border, Border, Border);
                try {
                    Image img = ImageIO.read(new File(Tablero.getPlayBoard()[i][j].getPiece().getImageURL())).getScaledInstance(Border, Border, java.awt.Image.SCALE_DEFAULT);
                    g.drawImage(img, (int) j * Border, (int) i * Border, null);
                } catch (Exception e) {
                }
            }
        }
    }
}
