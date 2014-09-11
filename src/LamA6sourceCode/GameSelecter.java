import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * \\file GameSelecter.java
 * \author Daniel 709547-A4, Chak Yan Lam 667271-A6
 * \date 16/04/2014
 * 
 * \brief Class which handles the choice of starting a new game
 * 
 * This class deals with handling giving the user
 * the option of starting either a new othello, tictactoe2 or
 * connect 4 game at the start of the application
 * and if they choose to start a new game.
 */
public class GameSelecter {
	/**
	 * Setter method to set the JButton m_connect4
	 * 
	 * \param newConnect4
	 * \return true on success
	 */
	public boolean setConnect4Button(JButton newConnect4) {
	    boolean test = false;
        if (test || m_test) {
            System.out.println("GameSelecter :: setConnect4Button() BEGIN");
        }
        
		m_connect4 = newConnect4;
		
        if (test || m_test) {
            System.out.println("GameSelecter :: setConnect4Button() END");
        }
		
		return true;
	}
	
	/**
	 * Setter method to set the JButton m_othello
	 * 
	 * \param newOthello
	 * \return true on success
	 */
	public boolean setOthelloButton(JButton newOthello) {
	    boolean test = false;
        if (test || m_test) {
            System.out.println("GameSelecter :: setOthelloButton() BEGIN");
        }
        
		m_othello = newOthello;
		
        if (test || m_test) {
            System.out.println("GameSelecter :: setOthelloButton() END");
        }
		
		return true;
	}
	
	/**
	 * Setter method to set the data for the JFrame m_choose
	 * 
	 * \param newChoose
	 * \return true on success
	 */
	public boolean setChooseFrame(JFrame newChoose) {
	    boolean test = false;
        if (test || m_test) {
            System.out.println("GameSelecter :: setChooseFrame() BEGIN");
        }
        
		m_choose = newChoose;
		
        if (test || m_test) {
            System.out.println("GameSelecter :: setChooseFrame() END");
        }
		
		return true;
	}
	
	/**
	 * Getter method to return the pointer for the JButton object m_connect4
	 * 
	 * \return JButton m_connect4
	 */
	public JButton getConnect4Button() {
	    boolean test = false;
        if (test || m_test) {
            System.out.println("GameSelecter :: getConnect4Button() BEGIN");
        }
        if (test || m_test) {
            System.out.println("GameSelecter :: getConnect4Button() END");
        }
        
		return m_connect4;
	}
	
	/**
	 * Getter method to return the JButton m_othello
	 * 
	 * \return JButton m_othello
	 */
	public JButton getOthelloButton() {
	    boolean test = false;
        if (test || m_test) {
            System.out.println("GameSelecter :: getOthelloButton() BEGIN");
        }
        if (test || m_test) {
            System.out.println("GameSelecter :: getOthelloButton() END");
        }
        
		return m_othello;
	}
	
	/**
	 * Getter method to return the object, the JFrame m_choose.
	 * 
	 * \return JFrame m_choose
	 */
	public JFrame getChooseFrame() {
	    boolean test = false;
        if (test || m_test) {
            System.out.println("GameSelecter :: getChooseFrame() BEGIN");
        }
        if (test || m_test) {
            System.out.println("GameSelecter :: getChooseFrame() END");
        }
        
		return m_choose;
	}
	
	/**
	* Constructor for the class GameSelecter 
	*/
	public GameSelecter() {
	    boolean test = false;
        if (test || m_test) {
            System.out.println("GameSelecter :: GameSelecter() BEGIN");
        }
        
		JFrame newChoose = new JFrame();
		setChooseFrame(newChoose);
		getChooseFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newChoose.setTitle("Select Game");
		
		Container panel = getChooseFrame().getContentPane();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));	
		
		ImageIcon connect4Image = null;
		ImageIcon othelloImage = null;
		ImageIcon tictactoeImage = null;
		try {
			connect4Image = new ImageIcon(getClass().getResource(
			                                         "/resource/connect4.jpg"));
			othelloImage = new ImageIcon(getClass().getResource(
			                                          "/resource/othello.jpg"));
			tictactoeImage = new ImageIcon(getClass().getResource(
                    								"/resource/Tic_Tac_Toe.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		ImageIcon connect4ImageIcon = connect4Image;
		ImageIcon othelloImageIcon = othelloImage;
		ImageIcon tictactoeImageIcon = tictactoeImage;
		
		JButton connect4 = new JButton("Connect 4");
		JButton othello = new JButton("Othello");
		JButton tictactoe = new JButton("Tic-Tac-Toe2");
		
		setConnect4Button(connect4);
		setOthelloButton(othello);
		
		ChooseEventHandler handler = new ChooseEventHandler();
		
		getConnect4Button().addActionListener(handler);
		getOthelloButton().addActionListener(handler);
		tictactoe.addActionListener(handler);
		
		panel.add(getConnect4Button());
		panel.add(getOthelloButton());
		panel.add(tictactoe);
		
		getConnect4Button().setIcon(connect4ImageIcon);
		getOthelloButton().setIcon(othelloImageIcon);
		tictactoe.setIcon(tictactoeImageIcon);
		
		getConnect4Button().setHorizontalTextPosition(SwingConstants.LEADING);
		getConnect4Button().setVerticalAlignment(SwingConstants.BOTTOM);
		
		getOthelloButton().setHorizontalTextPosition(SwingConstants.LEADING);
		getOthelloButton().setVerticalAlignment(SwingConstants.BOTTOM);
		
		tictactoe.setHorizontalTextPosition(SwingConstants.LEADING);
		tictactoe.setVerticalAlignment(SwingConstants.BOTTOM);
		
	    getChooseFrame().pack();
		getChooseFrame().setLocationRelativeTo(null);
        getChooseFrame().setVisible(true);
        
        if (test || m_test) {
            System.out.println("GameSelecter :: GameSelecter() END");
        }
	}
	
	class ChooseEventHandler implements ActionListener {

		/**
		*	Deals with actions performed by GUI objects, namley the buttons.
		*
		*	\param event - object which holds the data of the GUI event.
		*/
		public void actionPerformed(ActionEvent event) {
			Game game;
			if (event.getSource() == getOthelloButton()) {
				game = new Othello();
				PlayerSettings playerSettings = new PlayerSettings(game, 'O');
			} else if (event.getSource() == getConnect4Button()) {
				game = new ConnectFour();
				PlayerSettings playerSettings = new PlayerSettings(game, 'C');
			} else {
				game = new TicTacToe();
				PlayerSettings playerSettings = new PlayerSettings(game, 'T');
			}
			
			getChooseFrame().dispose();
		}
	}
	
	/**
	 * MAIN method - this is were the application begins
	 */
	public static void main(String[] args) {
		new GameSelecter();
	}
	
	/** connect four button */
	private JButton m_connect4;
	/** othello button */
	private JButton m_othello;
	/** jframe reference */
	private JFrame m_choose;
	/** test variable */
	private boolean m_test = false;
}
