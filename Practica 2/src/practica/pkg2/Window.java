/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author kiera
 */
public class Window extends JFrame implements MouseListener  {

	Board board;

	public Window() {
		JFrame MainMenu = new JFrame("Main Menu");
		MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainMenu.setSize(420, 300);
		JPanel Panel = new JPanel();
		JTextField QueenTextField = new JTextField(2);
		JTextField RookTextField = new JTextField(2);
		JTextField PawnTextField = new JTextField(2);
		JTextField BishopTextField = new JTextField(2);
		JTextField KnightTextField = new JTextField(2);
		JTextField KingTextField = new JTextField(2);
		JTextField BattleTowerTextField = new JTextField(2);
		JTextField SizeOfBoardTextField = new JTextField(2);

		JLabel QueenJlable1 = new JLabel("Do you want queens?");
		JLabel QueenJlable2 = new JLabel("How many queens:");
		JLabel RookJlable1 = new JLabel("Do you want rooks?");
		JLabel RookJlable2 = new JLabel("How many rooks:");
		JLabel PawnJlable1 = new JLabel("Do you want pawns?");
		JLabel PawnJlable2 = new JLabel("How many pawns:");
		JLabel BishopJlable1 = new JLabel("Do you want bishops?");
		JLabel BishopJlable2 = new JLabel("How many bishops:");
		JLabel KnightJlable1 = new JLabel("Do you want knights?");
		JLabel KnightJlable2 = new JLabel("How many knights:");
		JLabel KingJlable1 = new JLabel("Do you want kings?");
		JLabel KingJlable2 = new JLabel("How many kings:");
		JLabel BattleTowerJlable1 = new JLabel("Do you want battle towers?");
		JLabel BattleTowerJlable2 = new JLabel("How many battle towers:");
		JLabel SizeOfBoardJlable = new JLabel("Size of the board");

		JRadioButton QueenJRadioBUtton = new JRadioButton("Yes");
		JRadioButton RookJRadioBUtton = new JRadioButton("Yes");
		JRadioButton PawnJRadioBUtton = new JRadioButton("Yes");
		JRadioButton BishopJRadioBUtton = new JRadioButton("Yes");
		JRadioButton KnightJRadioBUtton = new JRadioButton("Yes");
		JRadioButton KingJRadioBUtton = new JRadioButton("Yes");
		JRadioButton BattleTowerJRadioBUtton = new JRadioButton("Yes");

		JButton Accept = new JButton("Accept");
		Accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				boardWindow();
				MainMenu.setVisible(false);
			}
		});

		Panel.add(QueenJlable1);
		Panel.add(QueenJRadioBUtton);
		Panel.add(QueenJlable2);
		Panel.add(QueenTextField);

		Panel.add(RookJlable1);
		Panel.add(RookJRadioBUtton);
		Panel.add(RookJlable2);
		Panel.add(RookTextField);

		Panel.add(PawnJlable1);
		Panel.add(PawnJRadioBUtton);
		Panel.add(PawnJlable2);
		Panel.add(PawnTextField);

		Panel.add(BishopJlable1);
		Panel.add(BishopJRadioBUtton);
		Panel.add(BishopJlable2);
		Panel.add(BishopTextField);

		Panel.add(KnightJlable1);
		Panel.add(KnightJRadioBUtton);
		Panel.add(KnightJlable2);
		Panel.add(KnightTextField);

		Panel.add(KingJlable1);
		Panel.add(KingJRadioBUtton);
		Panel.add(KingJlable2);
		Panel.add(KingTextField);

		Panel.add(BattleTowerJlable1);
		Panel.add(BattleTowerJRadioBUtton);
		Panel.add(BattleTowerJlable2);
		Panel.add(BattleTowerTextField);

		Panel.add(SizeOfBoardJlable);
		Panel.add(SizeOfBoardTextField);
		Panel.add(Accept);

		MainMenu.add(Panel);
		MainMenu.setVisible(true);

	}

	public void boardWindow() {
		board = new Board(6);
		JFrame frame = new JFrame();
		frame.setTitle("Practica 2: Las piezas que no se matan entre ellas");
		frame.setResizable(false);
		frame.setSize(board.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(board);
		frame.pack();

		frame.setVisible(true);
		frame.invalidate();
		frame.revalidate();
		frame.repaint();

	}

	@Override
	public void mouseClicked(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mousePressed(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseExited(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
