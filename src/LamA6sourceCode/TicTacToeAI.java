import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *  \\file	TicTacToeAI.Java
 * 	\author	Chak Yan Lam 667271-A6
 * 	\date	24/04/2014
 * 	
 * \brief The AI for TicTacToe to make a move
 * 
 * The following class sets the AI move for the TicTacToe game. Also there 
 * are controls of threads in this class for delaying the computer response
 * to add the feeling that the computer is 'thinking' about it's turn.
 * 
 */

public class TicTacToeAI extends Player{

	
	/**
	 * The method sets the response time for the AI to respond to the opponents
	 * move.
	 * 
	 * \param responseTime an integer value of which to set the response time to
	 * \return true if the method completes
	 */
	public boolean SetTime(int responseTime){
		boolean test = false;
		if (test || m_test) {
            System.out.println("TicTacToeAI :: SetTime() BEGIN");
            }
		m_time = responseTime;
		if (test || m_test) {
            System.out.println("TicTacToeAI :: SetTime() END");
            }
		return true;
		}
	
	/**
	 * The method returns the response time for the AI.
	 * \return m_time The response time for the AI
	 */
	public int getTime(){
		boolean test = false;
		if (test || m_test) {
            System.out.println("TicTacToeAI :: getTime() BEGIN");
            }
		if (test || m_test) {
            System.out.println("TicTacToeAI :: getTime() END");
            }
		return m_time;
	}
	
	/**
	 * The method sets when the thread is to be running, used for thread control
	 * \param run true when game is running, false when not.
	 * \return true if the method completes
	 */
	public Boolean SetRun(boolean run){
		boolean test = false;
		if (test || m_test) {
            System.out.println("TicTacToeAI :: SetRun() BEGIN");
            }
		m_running = run;
		if (test || m_test) {
			System.out.println("TicTacToeAI :: SetRun() END");
		}
		return true;
	}
	
	/**
	 * The method is getting whether the thread is supposed to be running or not
	 * \return m_running, true when game is running, false when not.
	 */
	public boolean getRun(){
		boolean test = false;
		if (test || m_test) {
            System.out.println("TicTacToeAI :: getRun() BEGIN");
            }
		if (test || m_test) {
			System.out.println("TicTacToeAI :: getRun() END");
		}
		return m_running;
	}
	
	/**
	 * The first constructor for setting a type of player of TicTacToeAI,
	 * all data is sent to the super class of Player. Sets the running state of
	 * the thread to be true.
	 * \param game the type of game (TicTacToe only due to PlayerSettings)
	 * \see PlayerSettings.java
	 * \param name the name of the player	 
	 * \param color the piece color of the player
	 */
	public TicTacToeAI(Game game, String name, Color color) {
		super(game, name, color);
		boolean test = false;
		if (test || m_test) {
            System.out.println("TicTacToeAI :: TicTacToeAI() BEGIN");
            }
		m_running = true;
		if (test || m_test) {
			System.out.println("TicTacToeAI :: TicTacToeAI() END");
		}
	}

	/**
	 * The second constructor for setting a type of player of TicTacToeAI,
	 * all data is sent to the super class of Player. Sets the running state of
	 * the thread to be true.
	 * \param game the type of game (TicTacToe only due to PlayerSettings)
	 * \see PlayerSettings.java
	 */
	public TicTacToeAI(Game game) {
		super(game);
		boolean test = false;
		if (test || m_test) {
            System.out.println("TicTacToeAI :: TicTacToeAI() BEGIN");
            }
		
		m_running = true;
		if (test || m_test) {
			System.out.println("TicTacToeAI :: TicTacToeAI() END");
		}
	}

	/**
	 * Loops through each coordinate on the board to check if the coordinate has
	 * a piece located there in the grid or not. 
	 * \return a list of available coordinates.
	 */
	private ArrayList<Coordinate> getAvailableMoves() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("TicTacToeAI :: getAvailableMoves() BEGIN");
            }
		ArrayList<Coordinate> list = new ArrayList<Coordinate>();
		if (getYourTurn()) {
			for(int x = 0;x<GAME_WIDTH;x++){
				for(int y = 0;y<GAME_HEIGHT;y++){
					if(getGame().getGrid().getCoordinate(x,y).getValue() == 
							Game.PlayerTurn.PLAYER1_AM ||
							getGame().getGrid().getCoordinate(x,y).getValue() == 
							Game.PlayerTurn.PLAYER2_AM ||
							getGame().getGrid().getCoordinate(x,y).getValue() == 
							Game.PlayerTurn.NONE ){
						Coordinate c1 = 
								new Coordinate(x,y,getGame().getPlayerTurn());
						list.add(c1);
						}
					}
				}
			}
		if (test || m_test) {
			System.out.println("TicTacToeAI :: getAvailableMoves() END");
		}
		return list;
	}

	/**
	 * method that sets the move that the AI will do. The method calls the
	 * getAvailableMoves() method above to get a list of available coordinates
	 * then looks for the move that has the biggest chain of pieces. 
	 * If all positions come out with a zero chain (Initial start of game) then
	 * the position will be picked to a random point.
	 * The game will also check if the opponent has a chain of 3 pieces, if so
	 * it will attempt to block the opponent unless it can win itself.
	 * \return Coordinate to take
	 */
	public Coordinate setAIMove() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("TicTacToeAI :: setAIMove() BEGIN");
            }
		ArrayList<Coordinate> listTwo = new ArrayList<Coordinate>();
		listTwo = getAvailableMoves();
		Coordinate takeCoord = null ;
		int maximum = 0;
		int countCounter = 0;
		if (!listTwo.isEmpty()){
		 takeCoord = listTwo.get(0);
		for (Coordinate coord : listTwo) {
			int move = getGame().moveScore(coord);
			if (move == 0){
				countCounter++;
			}
			if(move >= maximum) {
				takeCoord = coord;
				maximum = move;
			}
			if(maximum == WIN_CHAIN){
				return takeCoord;
			}
		}
		for(Coordinate coord2 : listTwo){
			if(getGame().blockOpponentChecker(coord2) == 
					WIN_CHAIN && maximum != WIN_CHAIN){
				return takeCoord = coord2;
			}
		}
		for(Coordinate coord2 : listTwo){
			if(getGame().blockOpponentChecker(coord2) == 
					WIN_CHAIN - 1 && maximum < WIN_CHAIN - 1){
				return takeCoord = coord2;
			}
		}
		
		if(countCounter == listTwo.size()){
			Random rnd = new Random();
			int count = NEG_ONE;
			while(count < COUNT3){
				takeCoord = listTwo.get(rnd.nextInt(listTwo.size()));
				if(takeCoord.getX() != 0 && takeCoord.getY() != 0 && 
						takeCoord.getX() != GAME_WIDTH - 1 && takeCoord.getY() != GAME_HEIGHT - 1){
					return takeCoord;
				}
				count++;
			}
		
		}
		
		maximum = 0;
		}
		if (test || m_test) {
			System.out.println("TicTacToeAI :: setAIMove() END");
		}
		return takeCoord;
	}

	/**
	 * method to make it set the turn of the AI to be it's move, then
	 * calls for the move to be taken
	 * \return true if the method completes
	 */
	public boolean isYourMove() throws InterruptedException {
		boolean test = false;
		if (test || m_test) {
            System.out.println("TicTacToeAI :: isYourMove() BEGIN");
            }
		setYourTurn(true);
		if (!(getGame().getPlayer1() instanceof Human || 
				getGame().getPlayer2() instanceof Human)){
			sendMove();
		}
		if (test || m_test) {
			System.out.println("TicTacToeAI :: isYourMove() END");
		}
		return true;
	}

	/**
	 * method that sends the coordinate to take back to the GameWindow class,
	 * Has a thread running so that it can make it 'feel' like the computer is
	 * deciding which piece to take to make the game feel more realistic.
	 * Calls setAIMove to get the available Coordinate. method was created to 
	 * allow AI to work.
	 * \see GameWindow.java
	 * \return true if the method completes
	 */
	public boolean sendMove() throws InterruptedException {
		boolean test = false;
		if (test || m_test) {
            System.out.println("TicTacToeAI :: sendMove() BEGIN");
            }
		new Thread(
				new Runnable() {
					public void run() {
						if(getRun()){
							try {
								Coordinate move ;
								Thread.sleep(getTime());
								move =setAIMove();
								if (getYourTurn()) {
									
									getGame().moveMade(move);
									
									setYourTurn(false);
									
								}
							} catch (InterruptedException | IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
		).start();
		if (test || m_test) {
			System.out.println("TicTacToeAI :: sendMove() END");
		}
		return true;
	}
	
	/**
	 * The default sendMove that was in the Player.java class. 
	 * Gets the move that the AI will do from the setAIMove method. Does the
	 * same as the sendMove() method above but is used in case it is called,
	 * above method was created to allow AI to work.
	 * \see Player.java
	 * \return true if the method completes
	 */
	public boolean sendMove(Coordinate move) throws InterruptedException {
		class MyThread implements Runnable {
			
				Coordinate m_move;
			   public MyThread(Coordinate move) {
			       // store parameter for later user
				   m_move = move;
			   }

			   public void run() {
				   if(getRun()){
						try {
							m_move = setAIMove();
						} catch (IndexOutOfBoundsException e) {
							e.printStackTrace();
						}
						if (getYourTurn()) {
							try {
								getGame().moveMade(m_move);
							} catch (InterruptedException | IOException e) {
								e.printStackTrace();
							}
							setYourTurn(false);
						}
				   }
			   }
			}
		Runnable r = new MyThread(move);
		r.wait(getTime());
		new Thread(r).start();
		return true;
		}
	
	/**
	 * Main method to initialise unit testing.
	 * \param args not used
	 */
	public static void main(String args[]){
		Game game = new TicTacToe();
		TicTacToeAI C4AI;
		TicTacToeAI C4AI2;

		C4AI2 = new TicTacToeAI(game, "test1",Color.blue);
		C4AI = new TicTacToeAI(game,"test2",Color.red);
		if(C4AI.getGame() == game)
			System.out.println("Set Game Success");
		if(C4AI.getPlayerName() == "test2")
			System.out.println("Name Set");
		if(C4AI.getPlayerColour() == Color.red)
			System.out.println("Color Ok");
		C4AI = new TicTacToeAI(game, "test3",Color.yellow);
		C4AI = new TicTacToeAI(game);
		System.out.println(C4AI.setAIMove());
		Coordinate cord = new Coordinate(C4AI.GAME_WIDTH,C4AI.GAME_HEIGHT,
				Game.PlayerTurn.PLAYER1);
		C4AI.SetTime(C4AI.GAME_WIDTH);
		if(C4AI.getTime() == C4AI.GAME_WIDTH)
			System.out.println("Time edited");
		C4AI.SetRun(true);
		if(C4AI.getRun() == true)
			System.out.println("Game Running");
	}
	
	

	/**The Game width and height of TicTacToe*/
	private final int GAME_WIDTH = 8;
	private final int GAME_HEIGHT = 8;
	/**To be able to use the value of -1 for the coding conventions*/
	private final int NEG_ONE = -1;
	/**The counter of pieces of value 2*/
	private final int COUNT2 = 2;
	/**The counter of pieces of value 3*/
	private final int COUNT3 = 3;
	/**The number of pieces in a row before the win*/
	private final int WIN_CHAIN = 3;
	/**Thread sleep time*/
	private int m_time = 1500;
	/**If the thread should be running or not*/
	private boolean m_running;
	/**For testing purposes*/
	private boolean m_test = true;
}

