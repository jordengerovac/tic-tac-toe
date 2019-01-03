import javax.swing.JFrame;

/**
 * This program constructs the TicTacToeFrame and sets its properties.
 * 
 * @author Jorden Gerovac
 */
public class TicTacToeViewer {
	public static void main (String[] args) {
		JFrame frame = new TicTacToeFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setTitle("Tic Tac Toe");
	    frame.setSize(400, 400);
	    frame.setVisible(true);
	}
}
