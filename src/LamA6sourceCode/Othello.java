import java.awt.Color;

import java.io.IOException;
import java.util.*;

/**
 *  \\file	Othello.Java
 * 	\author	-B. Golightly, Mathew Lloyd 711293
 * 	\date	-12/02/2014
 * 	
 * 	\brief	Extends Game with the rules of Othello as specified. 
 * 
 * Methods are move so that the AI can know how good it is, and provides a way 
 * to take a move, return a list of changes after a move has been made. 
 * In the case of Othello this means returning a list of captured 
 * pieces; other classes that also extend game may only return a list 
 * of one item i.e. only the piece that is the result of the move.
 */

public class Othello extends Game{
	
	/** 
	* Return the winning piece coordinates
	* \return m_win - the set which stores the winning piece coordinates
	*/
	public Set<Coordinate> getWin(){
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: getWin() BEGIN");
        }
        if (test || m_test) {
            System.out.println("Othello :: getWin() END");
        }
		return m_win;
	}
	
	
	/**
	* Empty the set which stores the winning piece coordinates
	*/
	protected void emptyWin(){
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: emptyWin() BEGIN");
        }
		m_win.clear();
		if (test || m_test) {
            System.out.println("Othello :: emptyWin() END");
        }
	}
	
	/**
	 * Constructor for a game of Othello
	 */
	public Othello() {
	
		super(GAME_WIDTH, GAME_HEIGHT);	
		
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: Othello() BEGIN");
        }

        if (test || m_test) {
            System.out.println("Othello :: Othello() END");
        }
	}
	
	/**
	 * Method to set up the grid, timer and window ready for a new game
	 * \throws InterruptedException
	 * @throws IOException 
	 */
	public void start() throws InterruptedException, IOException {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: start() BEGIN");
        }
        
		boolean m_Trace = false;
		
		if(m_Trace) { System.out.println("Game::Start() - Game has started");}
		setWindow(new GameWindow(this));
		resetGame();
		startTimer();
		availableMove();
		if (test || m_test) {
            System.out.println("Othello :: start() END");
        }
	}
	
	
	/**
	 * Resets the starting pieces.
	 * \throws InterruptedException 
	 * @throws IOException 
	 */
	public void resetGame() throws InterruptedException, IOException {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: resetGame() BEGIN");
        }
		Grid grid = super.getGrid();
		
		// Initialise starting pieces
		if (super.getPlayer1().getPlayerColour().equals(Color.BLACK))
		{
		    super.setPlayerTurn(Game.PlayerTurn.PLAYER1);
		    grid.setCoordinate(new Coordinate(COORD1, COORD1, Game.PlayerTurn.
		                                                              PLAYER1));
		    grid.setCoordinate(new Coordinate(COORD2, COORD1, Game.PlayerTurn.
		                                                              PLAYER2));
		    grid.setCoordinate(new Coordinate(COORD1, COORD2, Game.PlayerTurn.
		                                                              PLAYER2));
		    grid.setCoordinate(new Coordinate(COORD2, COORD2, Game.PlayerTurn.
		                                                              PLAYER1));
		    getPlayer1().isYourMove();
		    getWindow().displayPlayerTurn(Game.PlayerTurn.PLAYER1);
			if 	((getPlayer1() instanceof OthelloAI||getPlayer1() instanceof 
			                        AIEasy) && (getPlayer2() instanceof Human)){
				getPlayer1().sendMove();
			}
		}
		else 
		{
			super.setPlayerTurn(Game.PlayerTurn.PLAYER2);
			grid.setCoordinate(new Coordinate(COORD1, COORD1, Game.PlayerTurn.
			                                                          PLAYER2));
			grid.setCoordinate(new Coordinate(COORD2, COORD1, Game.PlayerTurn.
			                                                          PLAYER1));
			grid.setCoordinate(new Coordinate(COORD1, COORD2, Game.PlayerTurn.
			                                                          PLAYER1));
			grid.setCoordinate(new Coordinate(COORD2, COORD2, Game.PlayerTurn.
			                                                          PLAYER2));
			getPlayer2().isYourMove();
			getWindow().displayPlayerTurn(Game.PlayerTurn.PLAYER2);
			if 	((getPlayer2() instanceof OthelloAI || 
					getPlayer2() instanceof AIEasy)&&
					(getPlayer1() instanceof Human)){
				getPlayer2().sendMove();
			}
		}
		availableMove();
		
		if (test || m_test) {
            System.out.println("Othello :: resetGame() END");
        }
	}
	
	/**
	 * resets the game so a game can be loaded from file
	 * 
	 * \param p - player whos turn it is 
	 * \throws InterruptedException
	 */
	public void resetGame(Player p) throws InterruptedException {
        boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: resetGame() BEGIN");
        }
        
        if ((p instanceof Human)) {
            //DO NOTHING
        } else {
            p.sendMove();
        }
        availableMove();
        
        if (test || m_test) {
            System.out.println("Othello :: resetGame() END");
        }
    }
	
	/**
	 * (PRIVATE) Method to calculate possible moves for the player
	 */
	private void availableMove(){
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: availableMove() BEGIN");
        }
        
		for (int y = 0; y < GAME_HEIGHT; y++) {
			for (int x = 0; x < GAME_WIDTH; x++) {
				
				//reset
				if (getGrid().getCoordinate(x, y).getValue() == Game.PlayerTurn.
				          PLAYER1_AM || getGrid().getCoordinate(x, y).getValue() 
				                                  == Game.PlayerTurn.PLAYER2_AM)
				{
					getGrid().setCoordinate(new Coordinate(x, y, Game.PlayerTurn
					                                                    .NONE));
				}
				
				if (getPlayerTurn().equals(Game.PlayerTurn.PLAYER1)){
				  Coordinate c1 = new Coordinate(x, y, Game.PlayerTurn.PLAYER1);
				    if (isValidMove(c1)) {
					   Coordinate P1avaiableMov = 
					           new Coordinate(x, y, Game.PlayerTurn.PLAYER1_AM);
					   getGrid().setCoordinate(P1avaiableMov);
				   }
				}
				else if (getPlayerTurn().equals(Game.PlayerTurn.PLAYER2)) {
				   Coordinate c2 = new Coordinate(x, y, Game.PlayerTurn.PLAYER2);
				   if (isValidMove(c2)) { 
					   Coordinate P2avaiableMov = 
					           new Coordinate(x, y, Game.PlayerTurn.PLAYER2_AM);
					   getGrid().setCoordinate(P2avaiableMov);
				   }
				}
			}
		}
		if (test || m_test) {
            System.out.println("Othello :: availableMove() END");
        }
	}
	/**
	 * (PRIVATE) Method to check if a player can actually make a move.
	 * \return if the player can make a move or not 
	 */
	private boolean checkPassTurn(){
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: checkPassTurn() BEGIN");
        }
        
		for (int y = 0; y < GAME_HEIGHT; y++) {
			for (int x = 0; x < GAME_WIDTH; x++) {
				if (getGrid().getCoordinate(x, y).getValue() == Game.PlayerTurn.
				           PLAYER1_AM && getPlayerTurn().equals(Game.PlayerTurn.
				                                                      PLAYER1)){
					if (test || m_test) {
			            System.out.println("Othello :: checkPassTurn() END "
			                                                       + "(False)");
			        }
					return false;
				}
				if (getGrid().getCoordinate(x, y).getValue() == Game.PlayerTurn.
				           PLAYER2_AM && getPlayerTurn().equals(Game.PlayerTurn.
				                                                      PLAYER2)){
					if (test || m_test) {
			            System.out.println("Othello :: checkPassTurn() END "
			                                                       + "(False)");
			        }
					return false;
				}
			}
			}
		
		setPlayerTurn(nextPlayer());
		if (test || m_test) {
            System.out.println("Othello :: checkPassTurn() END (True)");
        }
		return true;
		
	}
	
	/**
	 * (PRIVATE) Queries the game to see if there are any valid moves remaining
	 * for either player.
	 * \return	True if a move can be made, false otherwise.
	 */
	private boolean isAnyValidMove() {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: isAnyValidMove() BEGIN");
        }
        
		// The game may end when the board is completely filled
		if (super.getTurnCount() == GAME_WIDTH * GAME_HEIGHT) {
			debug("IsAnyValidMove()", "board filled");
			if (test || m_test) {
	            System.out.println("Othello :: isAnyValidMove() END (False)");
	        }
			return false;
		}
		
		// Or when no valid moves remain (which may happen BEFORE the board
		// is fully filled (e.g. see Vlasakova 1 - 63 Schotte, European Grand 
		// Prix Prague 2011)
		test = false;
		for (int y = 0; y < GAME_HEIGHT; y++) {
			for (int x = 0; x < GAME_WIDTH; x++) {
				 Coordinate c1 = new Coordinate(x, y, Game.PlayerTurn.PLAYER1);
				 Coordinate c2 = new Coordinate(x, y, Game.PlayerTurn.PLAYER2);
				 
				 if (isValidMove(c1)) { 
					 if (test || m_test) {
				            System.out.println("Othello :: isAnyValidMove() END"
				                                                   + " (True)");
				     }
					 return true;
				 }
				 if (isValidMove(c2)) {
					 if (test || m_test) {
				            System.out.println("Othello :: isAnyValidMove() END"
				                                                   + " (True)");
				     }
					 return true; 
					 }
			}
		}
		test = true;
		
		// Otherwise...
		if (test || m_test) {
            System.out.println("Othello :: isAnyValidMove() END (False)");
        }
		return false;
	}
	/**
	 * Checks if a given player selecting a given coordinate is a valid move.
	 * \param xy A coordinate specifying x and y values into the grid.
	 * \return	True if the specified move can be made, false otherwise.
	 */
	protected boolean isValidMove(Coordinate xy) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: isValidMove() BEGIN");
        }
		debug("isValidMove", "" + xy, "");
		
		// Check that the move lies on the board somewhere vaugely sensible
		if (xy.getX() < 0) { throw new IllegalArgumentException("bad x value");}
		if (xy.getY() < 0) { throw new IllegalArgumentException("bad y value");}
		if (xy.getX() >= GAME_WIDTH)  { 
			throw new IllegalArgumentException("bad x value"); 
		}
		if (xy.getY() >= GAME_HEIGHT) {
			throw new IllegalArgumentException("bad y value"); 
		}
		if (xy.getValue() == Game.PlayerTurn.NONE) {
			throw new IllegalArgumentException("bad turn value"); 
		}
		
		// Check that the space is empty. If not, the move cannot be made.
		if (getGrid().getCoordinate(xy.getX(), xy.getY()).getValue() ==
			Game.PlayerTurn.PLAYER1 || 
			getGrid().getCoordinate(xy.getX(), xy.getY()).getValue() ==
			Game.PlayerTurn.PLAYER2) { return false; }
		
		// A move is valid if it "traps" the other player's pieces between
		// itself and another of the same player's piece, along diagonals or
		// horizontally or vertically. This means checking in eight directions.
		if (checkBound(xy, +1,  0)) { 
			if (test || m_test) {
            System.out.println("Othello :: isValidMove() END (True)");
			}
			return true; 
		} // right
		
		if (checkBound(xy, -1,  0)) {
			if (test || m_test) {
	            System.out.println("Othello :: isValidMove() END (True)");
	        }
			return true; 
		} // left
		
		if (checkBound(xy,  0, +1)) {
			if (test || m_test) {
	            System.out.println("Othello :: isValidMove() END (True)");
	        }
			return true; 
		} // down
		
		if (checkBound(xy,  0, -1)) {
			if (test || m_test) {
	            System.out.println("Othello :: isValidMove() END (True)");
	        }
			return true; 
		} // up
		
		if (checkBound(xy, +1, +1)) {
			if (test || m_test) {
	            System.out.println("Othello :: isValidMove() END (True)");
	        }
			return true; 
		} // bottom-right
		
		if (checkBound(xy, -1, +1)) {
			if (test || m_test) {
	            System.out.println("Othello :: isValidMove() END (True)");
	        }
			return true;
		} // bottom-left
		
		if (checkBound(xy, +1, -1)) {
			if (test || m_test) {
	            System.out.println("Othello :: isValidMove() END (True)");
	        }
			return true; 
		} // top-right
		
		if (checkBound(xy, -1, -1)) {
			if (test || m_test) {
	            System.out.println("Othello :: isValidMove() END (True)");
	        }
			return true; 
		} // top-left
		
		// otherrwise the move is invalid
		debug("isValidMove", "" + xy, "no bound found");
		
		if (test || m_test) {
            System.out.println("Othello :: isValidMove() END (False)");
        }
		return false;
	}
	
	/**
	 * (PRIVATE) checkBound checks to see if the opposing player's pieces
	 * are bound/trapped in a given direction by the current player's pieces.
	 * \param start - start coordinate
	 * \param xdir  - x direction 
	 * \param ydir - y direction
	 */
	private boolean checkBound(Coordinate start, int xdir, int ydir) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: checkBound() BEGIN");
        }
		Grid grid = getGrid();
		boolean opponentFound = false;
		
		//debug("checkBound", "" + start +", " + xdir +", " + ydir, "");
		
		Coordinate current = new Coordinate(start);
		current.move(xdir, ydir);
		
		while (current.within(0, 0, GAME_WIDTH, GAME_HEIGHT)) {
			Coordinate check = grid.getCoordinate(current);
			
			debug("checkBound", "checking " + check);
			
			if (check.isEmpty()) {
				// Finding an empty coordinate means that this isn't a valid
				// trap.
				debug("checkBound", "returns false due to check.isEmpty()");
				
				if (test || m_test) {
		            System.out.println("Othello :: checkBound() END (False)");
		        }
				return false;
			}
			else if (check.notEquals(start.getValue())) {
				// If the piece belongs to the opponent, then set a flag to
				// record this
				opponentFound = true;
			}
			else if (check.equals(start.getValue())) {
				// If the piece belongs to the current player, then it only
				// counts as bounding an opponent's piece if the flag has been
				// set.
				debug("checkBound()", "returns opponentFound==" +opponentFound);
				
				return opponentFound;
			}
			
			current.move(xdir, ydir);
		}
		
		debug("checkBound", "returns false (edge of grid)");
		if (test || m_test) {
            System.out.println("Othello :: checkBound() END (False)");
        }
		return false;
	}
	
	/**
	 * Takes a move, returning a list of squares to capture by the player (this
	 * doesn't actually write to the grid itself; this means that you can use
	 * this method to see how good a move is before you commit it to the grid -
	 * which would be helpful for implementing the AI).
	 * \param xy A coordinate specifying x and y values into the grid specifying
	 * 			 a valid move.
	 * \return	capture - A list of captured pieces, possibly of length zero,
	 *          as an array of coordinates specifying x, y, and
	 *          owning player value.
	 */
	protected ArrayList<Coordinate> takeMove(Coordinate xy) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: takeMove() BEGIN");
        }
		// In each direction, capture the opposing player's pieces if it is
		// bound by two of this player's pieces.
		
		// A list of changed/captured pieces to return
		ArrayList<Coordinate> capture = new ArrayList<Coordinate>();
				
		// "Capture" the current piece
		capture.add(xy);
		
		// Capture pieces in each direction
		capture.addAll(take(xy, -1,  0)); // left
		capture.addAll(take(xy, +1,  0)); // right
		capture.addAll(take(xy,  0, -1)); // up
		capture.addAll(take(xy,  0, +1)); // down
		capture.addAll(take(xy, -1, -1)); // top-left
		capture.addAll(take(xy, +1, -1)); // top-right
		capture.addAll(take(xy, -1, +1)); // bottom-left
		capture.addAll(take(xy, +1, +1)); // bottom-right
		if (test || m_test) {
            System.out.println("Othello :: takeMove() END");
        }
		return capture;
	}
	
	/**
	 * Calculates the potential score of a move, for use by an AI player who
	 * wants to pick the best move.
	 * \param xy A coordinate specifying x and y values into the grid.
	 * \return	The score of the move.
	 */
	public int moveScore(Coordinate xy) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: moveScore() BEGIN");
        }
        
		// Hint to whoever implements the Hard AI - just iterate over the
		// grid, then pick the best moveScore result. Your AI doesn't need to
		// know how to play Othello, it just needs to have a strategy that uses
		// Game/Othello.validMove and Game/Othello.moveScore. Simple!
		
		if (!isValidMove(xy)) { return 0; }
		
		ArrayList <Coordinate> captured = takeMove(xy);
		if (test || m_test) {
            System.out.println("Othello :: moveScore() END");
        }
		return captured.size();
	}
	
	/**
	 * Called whenever a player has made a move. Processes the move and calls
	 * the GUI and storage classes to store the processed move's data.
	 * 
	 * \param move The move which the player has made as a Coordinate class.
	 * 
	 * \throws InterruptedException
	 * \throws IOException 
	 */
	public void moveMade(Coordinate move) throws InterruptedException, IOException {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: moveMade() BEGIN");
        }
        
		boolean m_Trace = false;
		
		if(m_Trace) System.out.println("Othello::MoveMade() - Called");
		if(validateMove(move)) {
			if(m_Trace)System.out.println("Othello::MoveMade() -Move is valid");
			ArrayList<Coordinate> changes = takeMove(move);
			for(int i = 0; i < changes.size(); i++) {
				getGrid().setCoordinate(changes.get(i));
			}	
			getWindow().displayGrid(getGrid());
			if (((getPlayer1() instanceof OthelloAI || getPlayer1() instanceof 
			            AIEasy) && changes.get(0).getValue() == Game.PlayerTurn.
			            PLAYER1)|| ((getPlayer2() instanceof OthelloAI || 
			            getPlayer2() instanceof AIEasy) && changes.get(0).
			                            getValue() == Game.PlayerTurn.PLAYER2)){
				getWindow().SetAImove(changes.get(0));
			}
			getWindow().SetAnimation("flip", changes);
			setPlayer1Score(0);
			setPlayer2Score(0);
			for (int i = 0; i < getGrid().getGridWidth(); i++) {
				for (int j = 0; j< getGrid().getGridHeight(); j++) {
					if (getGrid().getCoordinate(i, j).getValue() == PlayerTurn.
					                                                  PLAYER1) {
						setPlayer1Score(getPlayer1Score() + 1);
					} else if (getGrid().getCoordinate(i, j).getValue() == 
					                                       PlayerTurn.PLAYER2) {
						setPlayer2Score(getPlayer2Score() + 1);
					}
				}
			}
			
			getWindow().updateScore(getPlayer1Score(), getPlayer2Score());
			setPlayerTurn(nextPlayer());
			 getWindow().displayPlayerTurn(getPlayerTurn());
			 availableMove();
			 if(checkPassTurn() && isAnyValidMove())
			 {
				  super.Getmessage(m_passmsg);
				 availableMove();
				 getWindow().displayPlayerTurn(getPlayerTurn());
			 }
			setTurnCount(getTurnCount() + 1);
		}
		
		if(isOver()) {
			if(m_Trace) System.out.println("Othello::MoveMade() - Game is "
			                                                      + "finished");
			try{
				new EndDisplay(this);
			} catch (IOException e){}
			emptyWin();
		} else {
			if (getPlayerTurn() == PlayerTurn.PLAYER1) {
				if(m_Trace) System.out.println("Othello::MoveMade() - "
				                                              + "Player1 next");
				getPlayer1().isYourMove();
			} else if(getPlayerTurn() == PlayerTurn.PLAYER2){
				if(m_Trace) System.out.println("Othello::MoveMade() - "
				                                              + "Player2 next");
				getPlayer2().isYourMove();
			}
		}
		//System.out.println("Grid:\n" + getGrid().toString() + "\n");
		if (test || m_test) {
            System.out.println("Othello :: moveMade() END");
        }
	}
	
	
	
	/**
	 * (PRIVATE) Captures pieces in a direction.
	 * \param xy A coordinate specifying x and y values into the grid.
	 * \param xdir Horizontal direction value in which to capture.
	 * \param ydir Vertical direction value in which to capture.
	 * \return	capture - A list of captured pieces, possibly of length zero,
	 *          as an array of coordinates specifying x, y, and
	 *          owning player value.
	 */
	private ArrayList<Coordinate> take(Coordinate xy, int xdir, int ydir) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: take() BEGIN");
        }
	
		if (!checkBound(xy, xdir, ydir)) { return new ArrayList<Coordinate>(); }
		
		Grid grid = getGrid();
		Coordinate current = new Coordinate(xy);
		
		ArrayList <Coordinate> capture = new ArrayList<Coordinate>();
		
		current.move(xdir, ydir);
		
		// The move is assumed to be valid at this point, so move over the
		// grid capturing any pieces belonging to the opponent
		while (current.within(0, 0, GAME_WIDTH, GAME_HEIGHT)) {
			Coordinate check = grid.getCoordinate(current);
			
			if (check.isEmpty()) { break; }
			
			if (check.notEquals(current.getValue())) {
				// If the piece belongs to the opponent, then capture it
				check.setValue(current.getValue());
				capture.add(check);
			}
			else {
				// If the piece belonds to the current player, then finish.
				break;
			}
			
    		current.move(xdir, ydir);
		}
		if (test || m_test) {
            System.out.println("Othello :: take() END");
        }
		return capture;
	}
	
	/**
	 * Checks to see if the game is over.
	 * \return	True if the game is over, false otherwise.
	 */
	public boolean isOver() {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: isOver() BEGIN");
        }
		// this concretely implements from the abstract game class
		if(!isAnyValidMove()){
			for (int i = 0; i < getGrid().getGridWidth(); i++) {
				for (int j = 0; j< getGrid().getGridHeight(); j++) {
					if (getGrid().getCoordinate(i, j).getValue() == PlayerTurn.
					                                                  PLAYER1) {
						m_p1.add(new Coordinate(i, j));
					} else if (getGrid().getCoordinate(i, j).getValue() == 
					                                       PlayerTurn.PLAYER2) {
						m_p2.add(new Coordinate(i, j));
					}
				}
			}
			if(m_p1.size() > m_p2.size()){
				m_win = new HashSet<Coordinate>(m_p1);
			} else if(m_p2.size() > m_p1.size()){
				m_win = new HashSet<Coordinate>(m_p2);
			}
	        getTimer().setRunning();
			m_p1.clear();
			m_p2.clear();
		}
		if (test || m_test) {
            System.out.println("Othello :: isOver() END");
        }
		return (!isAnyValidMove());
	}
	
	/**
	 * Checks to see if the game is over.
	 *
	 * \param end boolean for method overloading
	 * \return	True if the game is over, false otherwise.
	 */
	public boolean isOver(boolean end) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: isOver() BEGIN");
        }
		if (test || m_test) {
            System.out.println("Othello :: isOver() END");
        }
		return (!isAnyValidMove());
	}
	
	/**
	 * Returns the winner (once the game has ended). The winner is the one with
	 * the most captured pieces.
	 * \return The winning player, or null in the case of a tie.
	 */
	public Game.PlayerTurn isWinner() {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: isWinner() BEGIN");
        }
        
		if (!isOver())
			{ throw new IllegalStateException("no winner before game is over");}
		int score1 = getPlayer1Score();
		int score2 = getPlayer2Score();
		
		if (score1 > score2) {
			if (test || m_test) {
	            System.out.println("Othello :: isWinner() END");
	        }
			return Game.PlayerTurn.PLAYER1; 
		}
		else if (score2 > score1) {
			if (test || m_test) {
	            System.out.println("Othello :: isWinner() END");
	        }
			return Game.PlayerTurn.PLAYER2;
		}
		else { 
			if (test || m_test) {
	            System.out.println("Othello :: isWinner() END");
	        }
			return Game.PlayerTurn.NONE; 
		} 
	}
/**
 * Used to change which player's turn it currently is depending on the game 
 * rules.
 * 
 * \return Returns an enumerator of type PlayerTurn which indicates which turn 
 * it is, PLAYER1 or PLAYER2.
 */
	protected PlayerTurn nextPlayer() {
		boolean test= false;
		if (test || m_test) {
            System.out.println("Othello :: isWinner() BEGIN");
        }

		if(getPlayerTurn() == Game.PlayerTurn.PLAYER1) {
			if (test || m_test) {
	            System.out.println("Othello :: isWinner() END");
	        }
			return Game.PlayerTurn.PLAYER2;
		} 
		else {
			if (test || m_test) {
	            System.out.println("Othello :: isWinner() END");
	        }
			return Game.PlayerTurn.PLAYER1;
		}
	}
	
	
	/**
	 * Prints a debug message.
	 * \param method The name of the method printing the message.
	 * \param args   A string representation arguments of the method printing
	 * 				 the message.
	 * \param msg    A message to print.
	 */
	private void debug(String method, String args, String msg) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: debug() BEGIN");
        }
        
		if (!test) { return; }
		System.out.println("Othello::"+method+"("+args+") - "+msg);
		if (test || m_test) {
            System.out.println("Othello :: debug() END");
        }
	}
	
	/**
	 * Prints a debug message.
	 * \param method The name of the method printing the message.
	 * \param msg    A message to print.
	 */
	private void debug(String method, String msg) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: debug() BEGIN");
        }
		debug(method, "", msg);
		if (test || m_test) {
            System.out.println("Othello :: debug() END");
        }
	}
	
	/**
	* main used to run tests which create player and a game
	 * 
	 * \throws IOException 
	 * \throws InterruptedException
	 * \param args
	*/
	public static void main(String[] args) throws InterruptedException, 
	                                                               IOException {
		boolean test = true;
		if (test || m_test){
			Othello game = new Othello();
			Player player1 = new Human(game);
			Player player2 = new OthelloAI(game);
			player1.setPlayerName("Gavin");
			player2.setPlayerName("So");
			player1.setPlayerColour(Color.BLACK);
			player2.setPlayerColour(Color.WHITE);
			game.setPlayer1(player1);
			game.setPlayer2(player2);
			Coordinate testCooor	= new Coordinate(COORD1,COORD2, PlayerTurn.
			                                                           PLAYER1);
			Coordinate testCooor2	= new Coordinate(COORD1,COORD2, PlayerTurn.
			                                                           PLAYER2);
			Coordinate testCooor3	= new Coordinate(COORD2,COORD1, PlayerTurn.
			                                                           PLAYER1);
			Coordinate testCooor4	= new Coordinate(COORD2,COORD1, PlayerTurn.
			                                                           PLAYER2);
			game.start();
			
			game.moveMade(testCooor);
			System.out.println("Player 1 valid move :" + game.validateMove(
			                                                        testCooor));
			game.moveMade(testCooor2);
			System.out.println("Player 2 valid move :" + game.validateMove(
			                                                       testCooor2));
			game.moveMade(testCooor3);
			System.out.println("Player 1 valid move :" + game.validateMove(
			                                                       testCooor3));
			game.moveMade(testCooor4);
			System.out.println("Player 2 valid move :" + game.validateMove(
			                                                       testCooor4));
			
			
			
		}
	}
	/** Othello gameboard size */
	private final static int GAME_WIDTH  = 8;
	/** Othello gameboard size */
	private final static int GAME_HEIGHT = 8;
	/** starting position */
	private final static int COORD1 = 3;
	/** starting position */
	private final static int COORD2 = 4;
	/** store message  */
	private String m_passmsg = "There are no available moves, the turn has been"
	                                               + " passed to the opponent.";
	/** store winning pieces  */
	private Set<Coordinate> m_win = new HashSet<Coordinate>();
	/** store the pieces that will be flipped   */
	private Set<Coordinate> m_p1 = new HashSet<Coordinate>();
	/** store the pieces that will be flipped   */
	private Set<Coordinate> m_p2 = new HashSet<Coordinate>();
	/** test variable */
    private static boolean m_test = false;
}
