import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JSlider;

import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.event.*;
import javax.swing.JComboBox;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * \\file Drawing.java
 * \author Lewis Edwards 708830, Thomas Letheby, Chak Yan Lam 667271-A6
 * \date 26th April 2014
 * 
 * 
 * \brief Creates and updates the side bar.
 * 
 * This class creates the side bar for the game which includes information
 * such as player name, score and piece colour. This is also updated as the 
 * game continues.
 * 
 */
public class Drawing {

	/**
	 * Method to set the game board
	 * \param board name
	 */
	private void setBoard(String board){
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: setBoard() BEGIN");
            }
		gameBoardGraphics.SetBoard(board);
		
		if (test || m_test)
			System.out.println("Drawing::setBoard() - END");
	}
	/**
	 * Method to set the animation speed
	 * \param speed ,an integer, represents millisecond time 
	 * delay per movement
	 */
	private void setSpeed(int speed){
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: setSpeed() BEGIN");
            }
		gameBoardGraphics.SetSpeed(speed);
		m_responseTime = BASETIME + speed*TIME_RATIO;
		if(gameBoardGraphics.GetPlayer1() instanceof OthelloAI){
			((OthelloAI)gameBoardGraphics.GetPlayer1()).SetTime(m_responseTime);
		} else if(gameBoardGraphics.GetPlayer2() instanceof OthelloAI){		
			((OthelloAI)gameBoardGraphics.GetPlayer2()).SetTime(m_responseTime);
		} else if(gameBoardGraphics.GetPlayer1() instanceof ConnectFourAI){
			((ConnectFourAI)gameBoardGraphics.GetPlayer1()).
			                                            SetTime(m_responseTime);
		} else if(gameBoardGraphics.GetPlayer2() instanceof ConnectFourAI){
			((ConnectFourAI)gameBoardGraphics.GetPlayer2()).
			                                            SetTime(m_responseTime);
		} else if(gameBoardGraphics.GetPlayer1() instanceof AIEasy){
			((AIEasy)gameBoardGraphics.GetPlayer1()).SetTime(m_responseTime);
		} else if(gameBoardGraphics.GetPlayer2() instanceof AIEasy){
			((AIEasy)gameBoardGraphics.GetPlayer2()).SetTime(m_responseTime);
		} else if(gameBoardGraphics.GetPlayer1() instanceof TicTacToeAI){
			((TicTacToeAI)gameBoardGraphics.GetPlayer1()).SetTime(m_responseTime);
		} else if(gameBoardGraphics.GetPlayer2() instanceof TicTacToeAI){
			((TicTacToeAI)gameBoardGraphics.GetPlayer2()).SetTime(m_responseTime);
		}
		
		if (test || m_test)
			System.out.println("Drawing:: setSpeed() - END");
	}

	/**
	* Method responsible for setting AI move to GameBoardGraphics class
	* \param move - coordinate of AI move
	*/
	public void SetAImove(Coordinate move){
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: SetAImove() BEGIN");
            }
		gameBoardGraphics.SetAImove(move);
		
		if (test || m_test)
			System.out.println("Drawing:: SetAImove() - END");
	}
	
	/**
	* Method responsible for passing animation data to GameBoardGraphics class
	* \param type - type of animation that is either flip or fall
	* \param changes - the list stores the pieces which need the animation
	*/
	public void SetAnimation(String type, ArrayList<Coordinate> changes){
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: SetAnimation() BEGIN");
            }
		gameBoardGraphics.SetAnimation(type, changes);
		
		if (test || m_test)
			System.out.println("Drawing:: SetAnimation() - END");
	}
	
	/**
	 * Method to set the game is not over after the game restarts
	 * \param isOver - the boolean true means the game is over
	 */
	public void SetOver(boolean isOver){
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: SetOver() BEGIN");
            }
		gameBoardGraphics.SetOver(isOver);
		
		if (test || m_test)
			System.out.println("Drawing:: SetOver() - END");
	}
	
	/**
	 * This method sets the player 1 score on the side bar.
	 * \param score This hold the score for player 1 in an integer form.
	 */
	public void setPlayer1Score(int score){
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: setPlayer1Score() BEGIN");
            }
		m_player1Score.setText("" + score);	
		
		if (test || m_test)
			System.out.println("Drawing:: setPlayer1Score() - END");
	}
	
	/**
	 * This method sets the player 2 score on the side bar.
	 * \param score This hold the score for player 2 in an integer form.
	 */
	public void setPlayer2Score(int score){
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: setPlayer2Score() BEGIN");
            }
		m_player2Score.setText("" + score);	
		
		if (test || m_test)
			System.out.println("Drawing:: setPlayer2Score() - END");
	}
	
	/**
	* This method returns the sidebar panel for player 1.
	* \return This method retrives the score from the game for player 1
	*/
	public JLabel getPlayer1Score() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: getPlayer1Score() BEGIN");
            }
		
		
		if (test || m_test)
			System.out.println("Drawing::getPlayer1Score() - END");
		
		return m_player1Score;
	}
	
	/**
	* This method returns the sidebar panel for player 2.
	* \return This method retrives the score from the game for player 1
	*/
	public JLabel getPlayer2Score() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: getPlayer2Score() BEGIN");
            }
		
		
		if (test || m_test)
			System.out.println("Drawing:: getPlayer2Score() - END");
		
		return m_player2Score;
	}
	
	/**
	* This method sets the name of player 1.
	* \param label This stores the name of player 1
	*/
	public void setPlayer1Name(JLabel label) {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: setPlayer1Name() BEGIN");
            }
		m_player1Name = label;
		
		if (test || m_test)
			System.out.println("Drawing:: setPlayer1Name() - END");
	}
	
	/**
	* This method sets the name of player 2.
	* \param label This stores the name of player 2
	*/
	public void setPlayer2Name(JLabel label) {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: setPlayer2Name() BEGIN");
            }
		m_player2Name = label;
		
		if (test || m_test)
			System.out.println("Drawing:: setPlayer2Name() - END");
	}
	
	/**
	* This method returns the name of player 1.
	* \return m_player1Name This returns the name of player 1 when called
	*/
	public JLabel getPlayer1Name() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: getPlayer1Name() BEGIN");
            }
		
		
		if (test || m_test)
			System.out.println("Drawing:: getPlayer1Name() - END");
		
		return m_player1Name;
	}
	
	/**
	* This method returns the name of player 2.
	* \return m_player2Name This returns the name of player 2 when called
	*/
	public JLabel getPlayer2Name() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: getPlayer2Name() BEGIN");
            }
		
		if (test || m_test)
			System.out.println("Drawing:: getPlayer2Name() - END");
		return m_player2Name;
	}
	
	/**
	* This method takes in information about the number of turns taken and
	* stores it.
	* \param label This stores the information on the amount of turns taken
	*/
	public void setTurnsTaken(JLabel label) {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: setTurnsTaken() BEGIN");
            }
		m_turnsTaken = label;
		
		if (test || m_test)
			System.out.println("Drawing:: setTurnsTaken() - END");
	}
	
	/**
	* This method returns the number of turns that has been made.
	* \return m_turnsTaken This returns the amount of turns taken in the game
	*/
	public JLabel getTurnsTaken() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: getTurnsTaken() BEGIN");
            }
		
		if (test || m_test)
			System.out.println("Drawing:: getTurnsTaken() - END");
		return m_turnsTaken;
	}
	
	/**
	* This method assigns the information on the colour of the piece chosen by
	* player 1.
	* \param label This stores the information on the piece colour of player 1
	*/
	public void setPlayer1Piece(JLabel label) {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: setPlayer1Piece() BEGIN");
            }
		
		if (test || m_test)
			System.out.println("Drawing:: setPlayer1Piece() - END");
		m_player1Piece = label;
	}
	
	/**
	* This method assigns the information on the colour of the piece chosen by
	* player 2.
	* \param label This stores the information on the piece colour of player 2
	*/
	public void setPlayer2Piece(JLabel label) {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: setPlayer2Piece() BEGIN");
            }
		
		if (test || m_test)
			System.out.println("Drawing:: setPlayer2Piece() - END");
		m_player2Piece = label;
	}
	
	/**
	* This returns the colour of the piece chosen by player 1.
	* \return m_player1Piece This returns the colour of the player 1 piece
	*/
	public JLabel getPlayer1Piece() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: getPlayer1Piece() BEGIN");
            }
		
		if (test || m_test)
			System.out.println("Drawing:: getPlayer1Piece() - END");
		return m_player1Piece;
	}
	
	/**
	* This returns the colour of the piece chosen by player 2.
	* \return m_player2Piece This returns the colour of the player 2 piece
	*/
	public JLabel getPlayer2Piece() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: getPlayer2Piece() BEGIN");
            }
		
		if (test || m_test)
			System.out.println("Drawing:: getPlayer2Piece() - END");
		return m_player2Piece;
	}

	/**
	* This method sets the the player 1 side bar.
	* \param panel Instantiates m_barPlayer1 with JPanel
	*/
	public void setBarPlayer1(JPanel panel) {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: setBarPlayer1() BEGIN");
            }
		
		if (test || m_test)
			System.out.println("Drawing:: setBarPlayer1() - END");
		m_barPlayer1 = panel;
	}
	
	/**
	* This method sets the the player 2 side bar.
	* \param panel Instantiates m_barPlayer2 with JPanel
	*/
	public void setBarPlayer2(JPanel panel) {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: setBarPlayer2() BEGIN");
            }
		
		if (test || m_test)
			System.out.println("Drawing:: setBarPlayer2() - END");
		m_barPlayer2 = panel;
	}
	
	/**
	* This method returns the relevant information on the player 1
	* game panel.
	* \return m_barPlayer1 This returns the player 1 game info panel
	*/
	public JPanel getBarPlayer1() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: getBarPlayer1() BEGIN");
            }
		
		if (test || m_test)
			System.out.println("Drawing:: getBarPlayer1() - END");
		return m_barPlayer1;
	}
	
	/**
	* This method returns the relevant information on the player 2
	* game panel.
	* \return m_barPlayer2 This returns the player 2 game info panel
	*/
	public JPanel getBarPlayer2() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: getBarPlayer2() BEGIN");
            }
		
		if (test || m_test)
			System.out.println("Drawing:: getBarPlayer2() - END");
		return m_barPlayer2;
	}
	
	/**
	 * This method returns the graphics that were created.
	 * \return gameBoardGraphics when it is called.
	 */
	public GameBoardGraphics getGridPanel() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: getGridPanel() BEGIN");
            }
		
		if (test || m_test)
			System.out.println("Drawing:: getGridPanel() - END");
		return gameBoardGraphics;
	}
	
	/**
	 * This method returns the side bar that was created.
	 * \return m_sideBar - Returns the side bar which holds the scores for the game.
	 */
	public JPanel getSideBarPanel() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("Drawing :: getSideBarPanel() BEGIN");
            }
		
		if (test || m_test)
			System.out.println("Drawing:: getSideBarPanel() - END");
		return m_sideBar;
	}
	
	/**
	 * This method sets all relevant information for Player 1
	 * \param Player1 This is an object which holds data for player 1.
	 */
	public void setPlayer1(Player Player1) throws IOException{
		boolean m_Trace = false;
		
		getPlayer1Name().setText(Player1.getPlayerName());
		m_p1colour = Player1.getPlayerColour();
		if(m_p1colour.equals(Color.BLUE)){
			m_p1piece = ImageIO.read(getClass().getResource("/resource/cross3.png"));
			getPlayer1Piece().setIcon(new ImageIcon(CROSS));
		} else if(m_p1colour.equals(Color.GREEN)){
			m_p1piece = ImageIO.read(getClass().getResource("/resource/circle.png"));
			getPlayer1Piece().setIcon(new ImageIcon(CIRCLE));
		} else {
			m_p1piece = new BufferedImage
					(OVALSIZE, OVALSIZE, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D g2 = m_p1piece.createGraphics();
			if(m_p1colour.equals(Color.BLACK)){
				g2.setColor(Color.WHITE);
				g2.fillRect(0, 0, OVALSIZE, OVALSIZE);
			}
			g2.setColor(m_p1colour);
			g2.fillOval(0, 0, OVALSIZE, OVALSIZE);
			if(m_Trace) System.out.println
			("Drawing::SetPlayer1() - colour is " + Player1.getPlayerColour());
			getPlayer1Piece().setIcon(new ImageIcon(m_p1piece));
		}
	}
	
	/**
	 * This method sets all relevant information for Player 2
	 * \param Player2 This is an object which holds data for player 2.
	 */
	public void setPlayer2(Player Player2) throws IOException{
		boolean m_Trace = false;
		
		getPlayer2Name().setText(Player2.getPlayerName());
		m_p2colour = Player2.getPlayerColour();
		if(m_p2colour.equals(Color.BLUE)){
			m_p2piece = ImageIO.read(getClass().getResource("/resource/cross3.png"));;
			getPlayer2Piece().setIcon(new ImageIcon(CROSS));
		} else if(m_p2colour.equals(Color.GREEN)){
			m_p2piece = ImageIO.read(getClass().getResource("/resource/circle.png"));;
			getPlayer2Piece().setIcon(new ImageIcon(CIRCLE));
		} else {
			m_p2piece = new BufferedImage
					(OVALSIZE, OVALSIZE, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D g2 = m_p2piece.createGraphics();
			if(m_p2colour.equals(Color.BLACK)){
				g2.setColor(Color.WHITE);
				g2.fillRect(0, 0, OVALSIZE, OVALSIZE);
			}
			g2.setColor(m_p2colour);
			g2.fillOval(0, 0, OVALSIZE, OVALSIZE);
			if(m_Trace) System.out.println
			("Drawing::SetPlayer2() - colour is " + Player2.getPlayerColour());
			getPlayer2Piece().setIcon(new ImageIcon(m_p2piece));
		}
	}
	
	/**
	 * This method sets the players turns, and highlights the in turn player.
	 * \param PlayerTurn This holds information on the turns that have been
	 * taken.
	 * \param isAI indicates if the turn is an AI turn
	 * \throws IOException 
	 */
	public void setPlayerTurn(Game.PlayerTurn PlayerTurn, boolean isAI) throws IOException{
		
		if(PlayerTurn == Game.PlayerTurn.PLAYER1){
			getBarPlayer1().setBackground(Color.GRAY);
				
			Graphics2D g2;
			BufferedImage Piece;
			if(m_p1colour.equals(Color.BLUE)||m_p1colour.equals(Color.GREEN)){
				if(m_p1colour.equals(Color.BLUE)){
					Piece = ImageIO.read(getClass().getResource("/resource/cross3.png"));;
					g2 = Piece.createGraphics();
				} else {
					Piece = ImageIO.read(getClass().getResource("/resource/circle.png"));;
					g2 = Piece.createGraphics();
				}	
				g2.setColor(Color.GREEN);
			} else {
				Piece = new BufferedImage
						(OVALSIZE, OVALSIZE, BufferedImage.TYPE_3BYTE_BGR);
				g2 = Piece.createGraphics();
				if(m_p1colour.equals(Color.BLACK)){
					g2.setColor(Color.WHITE);
					g2.fillRect(0, 0, OVALSIZE, OVALSIZE);
				}
				g2.setColor(m_p1colour);
				g2.fillOval(0, 0, OVALSIZE, OVALSIZE);
				g2.setColor(m_p2colour);
			}	
			if(isAI){
				g2.drawString("AI", AI_X, YOUR_Y);
			} else {
				g2.drawString("YOUR", X, YOUR_Y);
			}
			g2.drawString("TURN", X, TURN_Y);
			getPlayer1Piece().setIcon(new ImageIcon(Piece));
			getPlayer2Piece().setIcon(new ImageIcon(m_p2piece));	
			
			getBarPlayer2().setBackground(Color.WHITE);
		} else {
			getBarPlayer2().setBackground(Color.GRAY);
			
			Graphics2D g2;
			BufferedImage Piece;
			if(m_p2colour.equals(Color.BLUE)||m_p2colour.equals(Color.GREEN)){
				if(m_p2colour.equals(Color.BLUE)){
					Piece = ImageIO.read(getClass().getResource("/resource/cross3.png"));;
					g2 = Piece.createGraphics();
				} else {
					Piece = ImageIO.read(getClass().getResource("/resource/circle.png"));;
					g2 = Piece.createGraphics();
				}	
				g2.setColor(Color.GREEN);
			} else {
				Piece = new BufferedImage
						(OVALSIZE, OVALSIZE, BufferedImage.TYPE_3BYTE_BGR);
				g2 = Piece.createGraphics();
				if(m_p2colour.equals(Color.BLACK)){
					g2.setColor(Color.WHITE);
					g2.fillRect(0, 0, OVALSIZE, OVALSIZE);
				}
				g2.setColor(m_p2colour);
				g2.fillOval(0, 0, OVALSIZE, OVALSIZE);
				g2.setColor(m_p1colour);
			}
			if(isAI){
				g2.drawString("AI", AI_X, YOUR_Y);
			} else {
				g2.drawString("YOUR", X, YOUR_Y);
			}
			g2.drawString("TURN", X, TURN_Y);
			getPlayer2Piece().setIcon(new ImageIcon(Piece));
			getPlayer1Piece().setIcon(new ImageIcon(m_p1piece));
			
			getBarPlayer1().setBackground(Color.WHITE);
		}
	}
	
	/**
	 * This method sets the grid.
	 * \param grid  Holds information on the grid
	 * \param game - reference to game
	 */
	public void setGrid(Grid grid, Game game){
		boolean m_Trace = false;
		if(game.isOver()){
			System.out.println("paintwin");
			gameBoardGraphics.setIsOver(true, game.getWin());
		}
		if(m_Trace) System.out.println
		("Drawing::SetGrid() - Grid has been updated");
		getGridPanel().setGrid(grid);
	}
	
	public boolean setTimerDisplay(String time) {
	    m_timerLabel.setText(time);
          
        return true;
    }
	
	/**
	 * \param game This receives an instance of the Game class.
	 * \param handler This receives the GUIEventHandler for the combobox 
	 * and slider
	 * 
	 * This method creates layout of the sidebar
	 */
	private boolean setLayout(Game game, GUIEventHandler handler){
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(PADDING,PADDING,PADDING,PADDING);
		GridBagLayout layout = new GridBagLayout();
		GridBagLayout layoutP1 = new GridBagLayout();
		GridBagLayout layoutP2 = new GridBagLayout();
		GridBagConstraints pc1 = new GridBagConstraints();
		GridBagConstraints pc2 = new GridBagConstraints();
		GridLayout setting = new GridLayout(SPEED_ROW,1);		
		m_sideBar = new JPanel(layout);
		JPanel BarTurn = new JPanel();
		getBarPlayer1().setLayout(layoutP1);
		getBarPlayer2().setLayout(layoutP2);
		layoutP1.setConstraints(getPlayer1Name(), pc1);
	    getBarPlayer1().add(getPlayer1Name());    
	    
	    pc1.gridy = P1SCOREY;
	    layoutP1.setConstraints(getPlayer1Score(), pc1);
	    getBarPlayer1().add(getPlayer1Score());    
	    pc1.gridy = P1PIECEY;
	    layoutP1.setConstraints(getPlayer1Piece(), pc1);
	    getBarPlayer1().add(getPlayer1Piece());        
	    layoutP2.setConstraints(getPlayer2Name(), pc2);
	    getBarPlayer2().add(getPlayer2Name());   
	    pc2.gridy = P2SCOREY;
	    layoutP2.setConstraints(getPlayer2Score(), pc2);
	    getBarPlayer2().add(getPlayer2Score());    
	    pc2.gridy = P2PIECEY;
	    layoutP2.setConstraints(getPlayer2Piece(), pc2);
	    getBarPlayer2().add(getPlayer2Piece());   
	    BarTurn.add(getTurnsTaken());	  
	    
	    m_sideBar.add(getBarPlayer1(),c);	    
	    c.gridy = BAR2GRIDY;
	    m_sideBar.add(getBarPlayer2(),c);
	    m_speed.setText("Game speed");
	    if(game instanceof ConnectFour){	
	    	gameBoardGraphics.SetSpeed(DEFAULT_FALL_SPEED);
			m_slider = new JSlider (MINSPEED, MAX_FALL_SPEED, 
			                                                DEFAULT_FALL_SPEED);
			m_isOthello = false;
	    } else {
	  		gameBoardGraphics.SetSpeed(DEFAULT_FLIP_SPEED);
	 		m_slider = new JSlider (MINSPEED, MAX_FLIP_SPEED, 
	 		                                                DEFAULT_FLIP_SPEED);
			m_isOthello = true;
	    }
	    
	    m_d = m_slider.getPreferredSize();
	    m_d.width = SLIDER_WIDTH;
	    m_slider.setPreferredSize(m_d);
		m_slider.addChangeListener(handler);
		m_slider.setInverted(true);    
	    m_setting.setLayout(setting);
		m_setting.add(m_speed);
		m_setting.add(m_slider);
		m_setting.setBackground(Color.WHITE);
		c.gridy = BAR3GRIDY;
		m_sideBar.add(m_setting,c);		
		String m_boards[] = new String[]{"board1","board2","board3"};
		m_skin = new JComboBox<String>(m_boards);
		m_skin.setSelectedIndex(0);
		m_skin.addActionListener(handler);	
		c.gridy = BAR3GRIDY + 1;
		m_sideBar.add(m_skin,c);
		c.gridy = BAR3GRIDY + GRID2;
        m_sideBar.add(m_timerLabel,c);
        return true;
	}
	
	/**
	 * \param game This creates an instance of the Game class.
	 * This method creates the panel and layout for the game to be played
	 * on, and adds the relevant information.
	 */
	public Drawing(Game game) throws IOException{
		boolean m_Trace = false;
		if(m_Trace) { System.out.println
			("Drawing::Drawing() - drawing initalizing");}
		
		if(m_Trace) { System.out.println
			("Drawing::Drawing() - Grid size = " + 
				game.getGrid().getGridWidth() + "X" + 
					game.getGrid().getGridHeight());}
		if(m_Trace) { System.out.println("Drawing::Drawing() - Players = " +
		        game.getPlayer2().getPlayerName() + ":" + 
				game.getPlayer1().getPlayerName());}
		try {
			gameBoardGraphics = new GameBoardGraphics
				(game.getGrid(), game.getPlayer1(), game.getPlayer2()); 
		}catch(java.io.IOException e){} 
		
		CIRCLE = ImageIO.read(getClass().getResource("/resource/circle.png"));
		CROSS = ImageIO.read(getClass().getResource("/resource/cross3.png"));
		setPlayer1(game.getPlayer1());
		setPlayer2(game.getPlayer2());
		
		handler = new GUIEventHandler();
		setLayout(game, handler);
		
		if(m_Trace) { System.out.println
			("Drawing::Drawing() -END");}
	}
	
	
	
	private class GUIEventHandler implements ActionListener, ChangeListener {
		
		//Change handler (e.g. for sliders)
        public void stateChanged(ChangeEvent e) {
	        	setSpeed(m_slider.getValue());
	        	if((m_isOthello && (m_slider.getValue() < DEFAULT_FLIP_SPEED - 
	        	        (DEFAULT_FLIP_SPEED/SPEED_ROW))) || (!m_isOthello && 
	        	        (m_slider.getValue() < DEFAULT_FALL_SPEED - 
	        	                              (DEFAULT_FALL_SPEED/SPEED_ROW)))){
	        		System.out.println(!m_isOthello && (m_slider.getValue() > 
	        		      DEFAULT_FALL_SPEED + (DEFAULT_FALL_SPEED/SPEED_ROW)));
	        		m_speed.setText("Fast");
	        	} else if((m_isOthello && m_slider.getValue() > 
	        	       DEFAULT_FLIP_SPEED + (DEFAULT_FLIP_SPEED/SPEED_ROW)) ||
	        		   (!m_isOthello && m_slider.getValue() > DEFAULT_FALL_SPEED
	        		                         + (DEFAULT_FALL_SPEED/SPEED_ROW))){
	        		m_speed.setText("Slow");
	        	} else {
	        		m_speed.setText("Normal");	
	        	}
        }
        public void actionPerformed(ActionEvent event) {
        	String m_board = (String)m_skin.getSelectedItem();
        	setBoard(m_board);
        }
    }
	

	public void Message(String msg) {
		JOptionPane.showMessageDialog(null,
			     msg,
			    "Information",
			    JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * This is the main method. It is used for testing purposes
	 */
	public static void main(String args[]) {
		ConnectFour game = new ConnectFour();
		Player player1 = new Human(game);
		Player player2 = new Human(game);
		player1.setPlayerName("Gavin");
		player2.setPlayerName("Lucy");
		player1.setPlayerColour(Color.RED);
		player2.setPlayerColour(Color.YELLOW);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		try{
			Drawing drawing = new Drawing(game);
			JFrame frame = new JFrame();
			frame.setLayout(new FlowLayout());
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(drawing.getGridPanel());
			frame.add(drawing.getSideBarPanel());
			drawing.setPlayerTurn(Game.PlayerTurn.PLAYER1, false);
			frame.pack();
		} catch (IOException e){}
	}
	
	
	/**Object reference that gets used for interacting with the graphics*/
	GameBoardGraphics gameBoardGraphics;
	/**Panels to display all the content*/
	private JPanel m_sideBar;
	private JPanel m_barPlayer1 = new JPanel();
	private JPanel m_barPlayer2 = new JPanel();
	private JPanel m_setting = new JPanel();
	
	/**Labels used in the game board display*/
	private JLabel m_player1Name = new JLabel();
	private JLabel m_player1Score = new JLabel("" + 0);
	private JLabel m_player2Name = new JLabel();
	private JLabel m_player2Score = new JLabel("" + 0);
	private JLabel m_turnsTaken = new JLabel();	
	private JLabel m_player1Piece = new JLabel();
	private JLabel m_player2Piece = new JLabel();
	/**Timer label*/
	private JLabel m_timerLabel = new JLabel("00:00:00");
	/**Changes the speed of the gameplay*/
	private JLabel m_speed = new JLabel("", JLabel.CENTER);
	private JSlider m_slider;
	/**Other GUI elements*/
	private Dimension m_d;
	private final GUIEventHandler handler;
	private JComboBox m_skin;
	private Color m_p1colour;
	private Color m_p2colour;
	private BufferedImage m_p1piece;
	private BufferedImage m_p2piece;
	/**The integers for changing the animation speeds and gameplay*/
	private final int SPEED_ROW = 2;
	private int m_responseTime;
	private final int PADDING = 6;
	private final int MINSPEED = 1;
	private final int MAX_FALL_SPEED = 40;
	private final int DEFAULT_FALL_SPEED = 20;
	private final int MAX_FLIP_SPEED = 20;
	private final int DEFAULT_FLIP_SPEED = 10;
	private final int SLIDER_WIDTH = 80;
	private final int BASETIME = 1000;
	private final int TIME_RATIO = 50;
	private final int OVALSIZE = 60;
	
	private final BufferedImage CIRCLE;
	private final BufferedImage CROSS;
	/**Layout value change*/
	private final int X = 14;
	private final int AI_X = 24;
	private final int YOUR_Y = 29;
	private final int TURN_Y = 39;
	private final int BAR2GRIDY = 1;
	private final int BAR3GRIDY = 2;
	private final int GRID2 = 2;
	/**Score values*/
	private final int P1SCOREY = 1;
	private final int P1PIECEY = 2;
	private final int P2SCOREY = 1;
	private final int P2PIECEY = 2;
	/**If the game is othello, this is true*/
	private boolean m_isOthello;
	/**Used for testing purposes*/
	private boolean m_test = true;
}
