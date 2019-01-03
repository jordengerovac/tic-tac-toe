import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * A TicTacToeFrame is the front end for the game.
 * 
 * @author Jorden Gerovac
 */
public class TicTacToeFrame extends JFrame{
	private String turn;
	private String winner;
	private JButton[] cell;
	private JButton restart;
	private JLabel result;
	private int availableSpots;
	
	/**
	 * Constructor for the TicTacToeFrame game board.
	 */
	public TicTacToeFrame() {
		setLayout(new GridLayout(4,3,10,10));
		availableSpots = 9;
		cell = new JButton[9];
		turn = "user";
		winner = "";
		result = new JLabel("");
		result.setBorder(new EmptyBorder(0,36,0,0));
		restart = new JButton();
		restart.setText("Restart Game");
		cell[0] = new JButton();
		cell[1] = new JButton();
		cell[2] = new JButton();
		cell[3] = new JButton();
		cell[4] = new JButton();
		cell[5] = new JButton();
		cell[6] = new JButton();
		cell[7] = new JButton();
		cell[8] = new JButton();
		cell[0].setFont(new Font("Arial", Font.BOLD, 50));
		cell[1].setFont(new Font("Arial", Font.BOLD, 50));
		cell[2].setFont(new Font("Arial", Font.BOLD, 50));
		cell[3].setFont(new Font("Arial", Font.BOLD, 50));
		cell[4].setFont(new Font("Arial", Font.BOLD, 50));
		cell[5].setFont(new Font("Arial", Font.BOLD, 50));
		cell[6].setFont(new Font("Arial", Font.BOLD, 50));
		cell[7].setFont(new Font("Arial", Font.BOLD, 50));
		cell[8].setFont(new Font("Arial", Font.BOLD, 50));
		getContentPane().setBackground(Color.darkGray);
		add(cell[0]);
		add(cell[1]);
		add(cell[2]);
		add(cell[3]);
		add(cell[4]);
		add(cell[5]);
		add(cell[6]);
		add(cell[7]);
		add(cell[8]);
		add(result);
		add(restart);
		
		class MyBoardListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					if (((JButton) event.getSource()).getText() == "")
						play(turn, event.getSource());
				}
				catch (Exception e){
					System.out.println(e);
				}
			}
		}
		ActionListener boardListener = new MyBoardListener();
		cell[0].addActionListener(boardListener);
		cell[1].addActionListener(boardListener);
		cell[2].addActionListener(boardListener);
		cell[3].addActionListener(boardListener);
		cell[4].addActionListener(boardListener);
		cell[5].addActionListener(boardListener);
		cell[6].addActionListener(boardListener);
		cell[7].addActionListener(boardListener);
		cell[8].addActionListener(boardListener);
		
		class MyRestartListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					cell[0].setEnabled(true);
					cell[1].setEnabled(true);
					cell[2].setEnabled(true);
					cell[3].setEnabled(true);
					cell[4].setEnabled(true);
					cell[5].setEnabled(true);
					cell[6].setEnabled(true);
					cell[7].setEnabled(true);
					cell[8].setEnabled(true);
					cell[0].setText("");
					cell[1].setText("");					
					cell[2].setText("");
					cell[3].setText("");
					cell[4].setText("");
					cell[5].setText("");
					cell[6].setText("");
					cell[7].setText("");
					cell[8].setText("");
					winner = "";
					availableSpots = 9;
					result.setText("");
				}
				catch (Exception e){
					System.out.println(e);
				}
			}
		}
		ActionListener restartListener = new MyRestartListener();
		restart.addActionListener(restartListener);
	}
	
	/**
	 * Adds an X or O depending on who's turn it is and checks to see if it is a winning move.
	 * 
	 * @param t the player who's turn it is
	 * @param object the button pressed
	 */
	public void play(String t, Object object) {
		JButton b = (JButton)object;
		b.setText("X");
		availableSpots -= 1;
		if(checkWin(turn) == "user"){
			result.setText("You win!");
			result.setForeground(Color.green);
			cell[0].setEnabled(false);
			cell[1].setEnabled(false);
			cell[2].setEnabled(false);
			cell[3].setEnabled(false);
			cell[4].setEnabled(false);
			cell[5].setEnabled(false);
			cell[6].setEnabled(false);
			cell[7].setEnabled(false);
			cell[8].setEnabled(false);
		}
		if (winner == "") {
			turn = "comp";
			if (availableSpots != 0){
				int choice = (int)Math.floor(Math.random() * 9);
				while(cell[choice].getText() != "") {
					choice = (int)Math.floor(Math.random() * 9);
				}
				cell[choice].setText("O");
				availableSpots -= 1;
				if(checkWin(turn) == "computer"){
					result.setText("You lose!");
					result.setForeground(Color.red);
					cell[0].setEnabled(false);
					cell[1].setEnabled(false);
					cell[2].setEnabled(false);
					cell[3].setEnabled(false);
					cell[4].setEnabled(false);
					cell[5].setEnabled(false);
					cell[6].setEnabled(false);
					cell[7].setEnabled(false);
					cell[8].setEnabled(false);
					
				}
				turn = "user";
			}
			else {
				result.setText("It's a draw!");
				result.setForeground(Color.white);
				cell[0].setEnabled(false);
				cell[1].setEnabled(false);
				cell[2].setEnabled(false);
				cell[3].setEnabled(false);
				cell[4].setEnabled(false);
				cell[5].setEnabled(false);
				cell[6].setEnabled(false);
				cell[7].setEnabled(false);
				cell[8].setEnabled(false);
			}
		}
	}
	
	/**
	 * Checks to see if there are three X's or O's in a row.
	 * 
	 * @param t the player who's turn it is
	 * @return winner of empty string 
	 */
	public String checkWin(String t){
		if (t == "user") {
			if (cell[0].getText() == "X" && cell[1].getText() == "X" && cell[2].getText() == "X") {
				winner = "user";
			}
			else if (cell[3].getText() == "X" && cell[4].getText() == "X" && cell[5].getText() == "X") {
				winner = "user";
			}
			else if (cell[6].getText() == "X" && cell[7].getText() == "X" && cell[8].getText() == "X") {
				winner = "user";
			}
			else if (cell[0].getText() == "X" && cell[3].getText() == "X" && cell[6].getText() == "X") {
				winner = "user";
			}
			else if (cell[1].getText() == "X" && cell[4].getText() == "X" && cell[7].getText() == "X") {
				winner = "user";
			}
			else if (cell[2].getText() == "X" && cell[5].getText() == "X" && cell[8].getText() == "X") {
				winner = "user";
			}
			else if (cell[0].getText() == "X" && cell[4].getText() == "X" && cell[8].getText() == "X") {
				winner = "user";
			}
			else if (cell[2].getText() == "X" && cell[4].getText() == "X" && cell[6].getText() == "X") {
				winner = "user";
			}
		}
		else {
			if (cell[0].getText() == "O" && cell[1].getText() == "O" && cell[2].getText() == "O") {
				winner = "computer";
			}
			else if (cell[3].getText() == "O" && cell[4].getText() == "O" && cell[5].getText() == "O") {
				winner = "computer";			
			}
			else if (cell[6].getText() == "O" && cell[7].getText() == "O" && cell[8].getText() == "O") {
				winner = "computer";
			}
			else if (cell[0].getText() == "O" && cell[3].getText() == "O" && cell[6].getText() == "O") {
				winner = "computer";			
			}
			else if (cell[1].getText() == "O" && cell[4].getText() == "O" && cell[7].getText() == "O") {
				winner = "computer";			
			}
			else if (cell[2].getText() == "O" && cell[5].getText() == "O" && cell[8].getText() == "O") {
				winner = "computer";			
			}
			else if (cell[0].getText() == "O" && cell[4].getText() == "O" && cell[8].getText() == "O") {
				winner = "computer";			
			}
			else if (cell[2].getText() == "O" && cell[4].getText() == "O" && cell[6].getText() == "O") {
				winner = "computer";			
			}
		}
		return winner;
	}
	
}
