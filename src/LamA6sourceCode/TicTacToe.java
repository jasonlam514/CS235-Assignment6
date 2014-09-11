import java.awt.Color;
import java.io.IOException;
import java.util.*;

/**
 * \\file TicTacToe.java 
 * \author -Chak Yan Lam 667271-A6
 * \date -24/04/2014
 * 
 * \brief Class that extends Game by using the rules of TicTacToe2.
 * 
 * Specifies the size of the board to be used. Sets the ways of winning
 * TicTacToe and what happens once happens once the game has ended. Doesn't
 * allow the user to click outside the grid.
 */

public class TicTacToe extends Game {

	/**
	 * Sets the winner of the game.
	 * 
	 * \param player The winner of the game as an enumerator Game.PlayerTurn.
	 */
	public void setWinner(Game.PlayerTurn player) {
		m_Winner = player;
	}

	/**
	 * Return the winning piece coordinates
	 * 
	 * \return the set which stores the winning piece coordinates
	 */
	public Set<Coordinate> getWin() {
		return m_win;
	}

	/**
	 * Returns the winner of the game.
	 * 
	 * \return The winner of the game as a enumerator Game.PlayerTurn.
	 */
	public Game.PlayerTurn getWinner() {
		return m_Winner;
	}

	/**
	 * Empty the set which stores the winning piece coordinates
	 */
	protected void emptyWin() {
		m_win.clear();
	}

	/**
	 * Construtor for a game of TicTacToe
	 */
	public TicTacToe() {
		super(GAME_WIDTH, GAME_HEIGHT);
	}

	/**
	 * Initialise TicTacToe
	 * \throws IOException 
	 */
	public void start() throws InterruptedException, IOException {
		boolean test = false;

		if (test || m_test) {
			System.out.println("TicTacToe::Start() BEGIN");
		}
		setWindow(new GameWindow(this));
		getPlayer1().isYourMove();
		getWindow().displayPlayerTurn(Game.PlayerTurn.PLAYER1);
		if ((getPlayer1() instanceof 
                TicTacToeAI) && (getPlayer2() instanceof Human)) {
			getPlayer1().sendMove();
		}
		startTimer();
		availableMove();
	}

	/**
	 * Resets the starting pieces. 
	 * \throws InterruptedException
	 * \throws IOException 
	 */
	public void resetGame() throws InterruptedException, IOException {
		boolean test = false;
		if (test || m_test) {
			System.out.println("TicTacToe::resetGame() BEGIN");
		}
		setWinner(Game.PlayerTurn.NONE);
		setPlayerTurn(PlayerTurn.PLAYER1);
		getPlayer1().isYourMove();
		if ((getPlayer1() instanceof 
                TicTacToeAI) && (getPlayer2() instanceof Human)) {
			getPlayer1().sendMove();
		}
		getWindow().displayPlayerTurn(Game.PlayerTurn.PLAYER1);
		if ((getPlayer1() instanceof 
                AIEasy) && (getPlayer2() instanceof Human)) {
			getPlayer1().sendMove();
		}
		availableMove();
		if (test || m_test) {
			System.out.println("TicTacToe::resetGame() END");
		}
	}
	
	/**
     * resets the game so a game can be loaded from file
     * 
     * \param p - player whos turn it is 
     * \throws InterruptedException
     */
    public void resetGame(Player p ) throws InterruptedException {
        boolean test = false;
        if (test || m_test) {
            System.out.println("TicTacToe::resetGame() BEGIN");
        }
        setWinner(Game.PlayerTurn.NONE);
        if ((p instanceof Human)) {
            //DO NOTHING
        } else {
            p.sendMove();
        }
        availableMove();
        if (test || m_test) {
            System.out.println("TicTacToe::resetGame() END");
        }
    }

	/**
	 * If the board is full there are no more valid moves
	 * 
	 * \return true if there is a valid move
	 */
	private boolean validMove() {
		boolean test = false;
		if (test || m_test) {
			System.out.println("TicTacToe::validMove() BEGIN");
		}
		if (getTurnCount() == GAME_WIDTH * GAME_HEIGHT) {
			if (test)
				System.out.println("TicTacToe::validMove() - No more valid "
				                                                     + "moves");
			return false;
		} else {
			if (test || m_test) {
				System.out.println("TicTacToe::validMove() END");
			}
			return true;
		}

	}
	
	/**
	 * (PRIVATE) Method to calculate possible moves for the player
	 */
	private void availableMove(){
		boolean test = false;
        if (test || m_test) {
            System.out.println("TicTacToe :: availableMove() BEGIN");
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
				   if (getGrid().getCoordinate(x, y).getValue() != Game.PlayerTurn.PLAYER1
						   && getGrid().getCoordinate(x, y).getValue() != Game.PlayerTurn.PLAYER2) {
					   Coordinate P1avaiableMov = 
					           new Coordinate(x, y, Game.PlayerTurn.PLAYER1_AM);
					   getGrid().setCoordinate(P1avaiableMov);
				   }
				}
				else if (getPlayerTurn().equals(Game.PlayerTurn.PLAYER2)) {
					if (getGrid().getCoordinate(x, y).getValue() != Game.PlayerTurn.PLAYER1
							   && getGrid().getCoordinate(x, y).getValue() != Game.PlayerTurn.PLAYER2) { 
					   Coordinate P2avaiableMov = 
					           new Coordinate(x, y, Game.PlayerTurn.PLAYER2_AM);
					   getGrid().setCoordinate(P2avaiableMov);
				   }
				}
			}
		}
		if (test || m_test) {
            System.out.println("TicTacToe :: availableMove() END");
        }
	}
	
	/**
	 * TicTacToe does not allow a move if the mouse is clicked outside the
	 * grid
	 * 
	 * \return true if there is a move available
	 */
	protected boolean isValidMove(Coordinate xy) {
		boolean test = false;
		if (test || m_test) {
			System.out.println("TicTacToe::isValidMove() BEGIN");
		}
		Grid grid = getGrid();

		if (xy.getX() < 0) {
			throw new IllegalArgumentException("bad x value");
		}
		if (xy.getX() < 0) {
			throw new IllegalArgumentException("bad y value");
		}
		if (xy.getX() >= GAME_WIDTH) {
			throw new IllegalArgumentException("bad x value");
		}
		if (xy.getY() >= GAME_HEIGHT) {
			throw new IllegalArgumentException("bad y value");
		}
		if (grid.getCoordinate(xy.getX(), xy.getY()).getValue() != 
		      Game.PlayerTurn.PLAYER1 && grid.getCoordinate(xy.getX(), 
		    		  xy.getY()).getValue() != Game.PlayerTurn.PLAYER2) {
			if (test || m_test)
				System.out
						.println("TicTacToe::isValidMove() - move is valid");
			return true;
		} else {
			if (test || m_test)
				System.out.println("TicTacToe::isValidMove() - move is not "
				                                                     + "valid");
			return false;
		}
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

		if (test || m_test)
			System.out.println("TicTacToe::MoveMade() - BEGIN");
		if (validateMove(move)) {
			if (test || m_test)
				System.out.println("TicTacToe::MoveMade() - Move is valid");
			ArrayList<Coordinate> changes = takeMove(move);
			for (int i = 0; i < changes.size(); i++) {
				getGrid().setCoordinate(changes.get(i));
			}
			getWindow().displayGrid(getGrid());
			setPlayer1Score(0);
			setPlayer2Score(0);
			for (int i = 0; i < getGrid().getGridWidth(); i++) {
				for (int j = 0; j < getGrid().getGridHeight(); j++) {
					if (getGrid().getCoordinate(i, j).getValue() == 
					                                       PlayerTurn.PLAYER1) {
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
			setTurnCount(getTurnCount() + 1);
		}

		if (isOver()) {
			if (test || m_test)
				System.out.println("TicTacToe::MoveMade() - TicTacToe is "
				                                                  + "finished");
			try{
				new EndDisplay(this);
			} catch (IOException e){}
			emptyWin();
		} else {
			if (getPlayerTurn() == PlayerTurn.PLAYER1) {
				if (test || m_test)
					System.out
							.println("TicTacToe::MoveMade() - Player1 next");
				getPlayer1().isYourMove();
			} else if (getPlayerTurn() == PlayerTurn.PLAYER2) {
				if (test || m_test)
					System.out
							.println("TicTacToe::MoveMade() - Player2 next");
				getPlayer2().isYourMove();
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::MoveMade() - END");
	}

	/**
	 * Take a move with given coordinate
	 * 
	 * \return a list containing the taken move
	 */
	protected ArrayList<Coordinate> takeMove(Coordinate xy) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::takeMove() - BEGIN");
		ArrayList<Coordinate> capture = new ArrayList<Coordinate>();
		// "Capture" the current piece
		capture.add(new Coordinate(xy.getX(), xy.getY(), xy.getValue()));
		// Capture pieces in each direction
		if (test || m_test)
			System.out.println("TicTacToe::takeMove() - END");
		return capture;
	}

	/**
	 * Sets the ways in which a game can be ended
	 * 
	 * \return true if the game is over
	 */
	public boolean isOver() {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::isOver() - BEGIN");
		checkWinner();
		if (getWinner() == Game.PlayerTurn.PLAYER1
				                    || getWinner() == Game.PlayerTurn.PLAYER2) {
			if (test || m_test)
				System.out.println("TicTacToe::IsOver() - A Player has won");
			getTimer().setRunning();
			return true;
		} else {
			if (test || m_test)
				System.out.println("TicTacToe::IsOver() - Valid move");
			return (!validMove());
		}
	}

	/**
	 * Sets the ways in which a game can be ended
	 * 
	 * \param end boolean for method overloading
	 * \return true if the game is over
	 */
	public boolean isOver(boolean end) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::isOver() - BEGIN");
		if (test || m_test)
			System.out.println("TicTacToe::IsOver() - Valid move");
		return getWinner() == Game.PlayerTurn.PLAYER1
                || getWinner() == Game.PlayerTurn.PLAYER2;
	}
	
	/**
	 * Sets how the game will check who the winner is
	 */
	private void checkWinner() {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::checkWinner() - BEGIN");
		for (int y = 0; y < GAME_HEIGHT; y++) {
			for (int x = 0; x < GAME_WIDTH; x++) {

				checkRight(x, y);
				checkDown(x, y);
				checkDiagonalUp(x, y);
				checkDiagonalDown(x, y);
			}

		}
		if (test || m_test)
			System.out.println("TicTacToe::checkWinner() - END");
	}

	/**
	 * Checks right from the last counter that has been placed to check if there
	 * are 4 counter of the same colour in a row
	 * 
	 * \param xy the piece that has been placed
	 * 
	 * \param Player check if the square is empty
	 */
	private void checkRight(int x, int y) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::checkRight() - BEGIN");
		Grid grid = getGrid();
		Game.PlayerTurn Player = grid.getCoordinate(x, y).getValue();
		if(Player == Game.PlayerTurn.PLAYER1 || Player == Game.PlayerTurn.PLAYER2){
			if (x < GAME_WIDTH - COUNT3) {
				if ((grid.getCoordinate(x + 1, y).getValue() == Player) && 
				        (grid.getCoordinate(x + COUNT2, y).getValue() == Player)
				        && (grid.getCoordinate(x + COUNT3, y).getValue() == 
				                                                      Player)) {
					m_win.add(new Coordinate(x, y));
					m_win.add(new Coordinate(x + 1, y));
					m_win.add(new Coordinate(x + COUNT2, y));
					m_win.add(new Coordinate(x + COUNT3, y));
					setWinner(Player);
				}
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::checkRight() - END");
	}

	/**
	 * Count right pieces from the last counter that has been placed
	 * 
	 * \param xy the piece that has been placed
	 * 
	 * \param Player check if the square is empty
	 * 
	 * \return count number of pieces
	 */
	private int countRight(Coordinate xy, Game.PlayerTurn Player) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::countRight() - BEGIN");
		int x = xy.getX();
		int y = xy.getY();
		int count = 0;
		int loopCount = 0;
		Grid grid = getGrid();
		if (Player != Game.PlayerTurn.NONE) {
			if (x < GAME_WIDTH - 1) {
				loopCount = 1;
			}
			if (x < GAME_WIDTH - COUNT2) {
				loopCount = COUNT2;
			}
			if (x < GAME_WIDTH - COUNT3) {
				loopCount = COUNT3;
			}
			for (int z = 1; z <= loopCount; z++) {
				Game.PlayerTurn Player2 = grid.getCoordinate((x + z), y)
						.getValue();
				if (Player2.equals(Player)) {
					count++;
				} else {
					return count;
				}
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::countRight() - END");
		return count;
	}

	/**
	 * Count left pieces from the last counter that has been placed
	 * 
	 * \param xy the piece that has been placed
	 * 
	 * \param Player check if the square is empty
	 * 
	 * \return count number of pieces
	 */
	private int countLeft(Coordinate xy, Game.PlayerTurn Player) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::countLeft() - BEGIN");
		int x = xy.getX();
		int y = xy.getY();
		int count = 0;
		int loopCount = 0;
		Grid grid = getGrid();
		if (Player != Game.PlayerTurn.NONE) {
			if (x > 0) {
				loopCount = 1;
			}
			if (x > 1) {
				loopCount = COUNT2;
			}
			if (x > COUNT2) {
				loopCount = COUNT3;
			}
			for (int z = 1; z <= loopCount; z++) {
				Game.PlayerTurn Player2 = grid.getCoordinate((x - z), y)
						.getValue();
				if (Player2.equals(Player)) {
					count++;
				} else {
					return count;
				}
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::countLeft() - END");
		return count;
	}

	/**
	 * Checks downwards from the last counter that has been placed to see if
	 * there are 4 counter of the same colour in a row
	 * 
	 * \param x the x value to check
	 * 
	 * \param y the y value to check
	 * 
	 */
	private void checkDown(int x, int y) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::checkDown() - BEGIN");
		Grid grid = getGrid();

		Game.PlayerTurn Player = grid.getCoordinate(x, y).getValue();
		if(Player == Game.PlayerTurn.PLAYER1 || Player == Game.PlayerTurn.PLAYER2){
			if (y < GAME_HEIGHT - COUNT3) {
				if ((grid.getCoordinate(x, y + 1).getValue() == Player) && 
				        (grid.getCoordinate(x, y + COUNT2).getValue() == Player)
						&& (grid.getCoordinate(x, y + COUNT3).getValue() == 
						                                              Player)) {
					m_win.add(new Coordinate(x, y));
					m_win.add(new Coordinate(x, y + 1));
					m_win.add(new Coordinate(x, y + COUNT2));
					m_win.add(new Coordinate(x, y + COUNT3));
					setWinner(Player);
				}
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::checkDown() - END");
	}

	/**
	 * Count down pieces from the last counter that has been placed
	 * 
	 * \param xy the piece that has been placed
	 * 
	 * \param Player check if the square is empty
	 * 
	 * \return count number of pieces
	 */
	private int countDown(Coordinate xy, Game.PlayerTurn Player) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::countDown() - BEGIN");
		int x = xy.getX();
		int y = xy.getY();
		int count = 0;
		int loopCount = 0;
		Grid grid = getGrid();
		if (Player != Game.PlayerTurn.NONE) {
			if (y < GAME_HEIGHT - 1) {
				loopCount = 1;
			}
			if (y < GAME_HEIGHT - COUNT2) {
				loopCount = COUNT2;
			}
			if (y < GAME_HEIGHT - COUNT3) {
				loopCount = COUNT3;
			}
			for (int z = 1; z <= loopCount; z++) {
				Game.PlayerTurn Player2 = grid.getCoordinate(x, (y + z))
						                                            .getValue();
				if (Player2.equals(Player)) {
					count++;
				} else {
					return count;
				}
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::countDown() - END");
		return count;
	}
	
	/**
	 * Count up pieces from the last counter that has been placed
	 * 
	 * \param xy the piece that has been placed
	 * 
	 * \param Player check if the square is empty
	 * 
	 * \return count number of pieces
	 */
	private int countUp(Coordinate xy, Game.PlayerTurn Player) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::countUp() - BEGIN");
		int x = xy.getX();
		int y = xy.getY();
		int count = 0;
		int loopCount = 0;
		Grid grid = getGrid();
		if (Player != Game.PlayerTurn.NONE) {
			if (y > 0) {
				loopCount = 1;
			}
			if (y > 1) {
				loopCount = COUNT2;
			}
			if (y > COUNT2) {
				loopCount = COUNT3;
			}
			for (int z = 1; z <= loopCount; z++) {
				Game.PlayerTurn Player2 = grid.getCoordinate(x, (y - z))
						                                            .getValue();
				if (Player2.equals(Player)) {
					count++;
				} else {
					return count;
				}
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::countUp() - END");
		return count;
	}

	/**
	 * Find the longest chain on the gamebaord and return the length of the
	 * chain
	 * 
	 * \param xy the piece that has been placed
	 * 
	 * \return count the length of the chain
	 * 
	 */
	public int moveScore(Coordinate xy) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::moveScore() - BEGIN");
		int count = 0;
		int countDown = countDown(xy, getPlayerTurn());
		int countUp = countUp(xy, getPlayerTurn());
		int countDiagDown = countDiagonalDown(xy, getPlayerTurn());
		int countDiagDownLeft = countDiagonalDownLeft(xy, getPlayerTurn());
		int countDiagUp = countDiagonalUp(xy, getPlayerTurn());
		int countDiagUpLeft = countDiagonalUpLeft(xy, getPlayerTurn());
		int countLeft = countLeft(xy, getPlayerTurn());
		int countRight = countRight(xy, getPlayerTurn());

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(countDiagUpLeft);
		list.add(countDiagUp);
		list.add(countDown);
		list.add(countUp);
		list.add(countDiagDown);
		list.add(countDiagDownLeft);
		list.add(countLeft);
		list.add(countRight);

		int equalsCounter = 0;
		for (Integer listIter : list) {
			if (listIter == count) {
				equalsCounter++;
			} else if (listIter > count) {
				count = listIter;
			}
		}

		if (equalsCounter == list.size()) {
			count = 0;
		}
		if (test || m_test)
			System.out.println("TicTacToe::moveScore() - END");
		return count;

	}

	/**
	 * block the opponent chain if the length of the chain is 3
	 * 
	 * \param xy the piece that has been placed from opponent
	 * 
	 * \return count if the length of the chain is 3
	 */
	public int blockOpponentChecker(Coordinate xy) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::blockOpponentChecker() - BEGIN");
		Game.PlayerTurn Player;

		if (getPlayerTurn() == Game.PlayerTurn.PLAYER1) {
			Player = Game.PlayerTurn.PLAYER2;
		} else {
			Player = Game.PlayerTurn.PLAYER1;
		}

		Coordinate c1 = new Coordinate(xy.getX(), xy.getY());
		int count = 0;
		int countDown = countDown(c1, Player);
		int countUp = countUp(c1, Player);
		int countDiagDown = countDiagonalDown(c1, Player);
		int countDiagDownLeft = countDiagonalDownLeft(c1, Player);
		int countDiagUpLeft = countDiagonalUpLeft(c1, Player);
		int countDiagUp = countDiagonalUp(c1, Player);
		int countLeft = countLeft(c1, Player);
		int countRight = countRight(c1, Player);

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(countDown);
		list.add(countUp);
		list.add(countDiagDown);
		list.add(countDiagDownLeft);
		list.add(countDiagUpLeft);
		list.add(countDiagUp);
		list.add(countLeft);
		list.add(countRight);

		for (Integer listIter : list) {
			if (listIter == COUNT3) {
				return COUNT3;
			}
			if (listIter == COUNT2) {
				count = COUNT2;
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::blockOpponentChecker() - END");
		return count;
	}

	/**
	 * Count diagonal down right pieces from the last counter that has been placed
	 * 
	 * \param xy the piece that has been placed
	 * 
	 * \param Player check if the square is empty
	 * 
	 * \return count number of pieces
	 */
	private int countDiagonalDown(Coordinate xy, Game.PlayerTurn Player) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::countDiagonalDown() - BEGIN");
		int x = xy.getX();
		int y = xy.getY();
		int count = 0;
		int loopCount = 0;
		Grid grid = getGrid();
		if (Player != Game.PlayerTurn.NONE) {
			if (y < GAME_HEIGHT - 1 && x < GAME_WIDTH - 1) {
				loopCount = 1;
			}
			if (y < GAME_HEIGHT - COUNT2 && x < GAME_WIDTH - COUNT2) {
				loopCount = COUNT2;
			}
			if (y < GAME_HEIGHT - COUNT3 && x < GAME_WIDTH - COUNT3) {
				loopCount = COUNT3;
			}
			for (int z = 1; z <= loopCount; z++) {
				Game.PlayerTurn Player2 = grid.getCoordinate((x + z), (y + z))
						.getValue();
				if (Player2.equals(Player)) {
					count++;
				} else {
					return count;
				}
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::countDiagonalDown() - END");
		return count;
	}
	
	/**
	 * Count diagonal down left pieces from the last counter that has been placed
	 * 
	 * \param xy the piece that has been placed
	 * 
	 * \param Player check if the square is empty
	 * 
	 * \return count number of pieces
	 */
	private int countDiagonalDownLeft(Coordinate xy, Game.PlayerTurn Player) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::countDiagonalDownLeft() - BEGIN");
		int x = xy.getX();
		int y = xy.getY();
		int count = 0;
		int loopCount = 0;
		Grid grid = getGrid();
		if (Player != Game.PlayerTurn.NONE) {
			if (y < GAME_HEIGHT - 1 && x > 0) {
				loopCount = 1;
			}
			if (y < GAME_HEIGHT - COUNT2 && x > 1) {
				loopCount = COUNT2;
			}
			if (y < GAME_HEIGHT - COUNT3 && x > COUNT2) {
				loopCount = COUNT3;
			}
			for (int z = 1; z <= loopCount; z++) {
				Game.PlayerTurn Player2 = grid.getCoordinate((x - z), (y + z))
						.getValue();
				if (Player2.equals(Player)) {
					count++;
				} else {
					return count;
				}
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::countDiagonalDownLeft() - END");
		return count;
	}
	
	/**
	 * Count diagonal up left pieces from the last counter that has been placed
	 * 
	 * \param xy the piece that has been placed
	 * 
	 * \param Player check if the square is empty
	 * 
	 * \return count number of pieces
	 */
	private int countDiagonalUpLeft(Coordinate xy, Game.PlayerTurn Player) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::countDiagonalUpLeft() - BEGIN");
		int x = xy.getX();
		int y = xy.getY();
		int count = 0;
		int loopCount = 0;
		Grid grid = getGrid();
		if (Player != Game.PlayerTurn.NONE) {
			if (x > 0 && y > 0) {
				loopCount = 1;
			}
			if (x > 1 && y > 1) {
				loopCount = COUNT2;
			}
			if (x > COUNT2 && y > COUNT2) {
				loopCount = COUNT3;
			}
			for (int z = 1; z <= loopCount; z++) {
				Game.PlayerTurn Player2 = grid.getCoordinate((x - z), (y - z))
						.getValue();
				if (Player2.equals(Player)) {
					count++;
				} else {
					return count;
				}
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::countDiagonalUpLeft() - END");
		return count;
	}
	
	/**
	 * Checks downwards in a diagonal direction from the last counter that has
	 * been placed to check if there are 4 counter of the same colour in a row
	 * 
	 * \param x the x value to check
	 * 
	 * \param y the y value to check
	 */
	private void checkDiagonalDown(int x, int y) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::checkDiagonalDown() - BEGIN");
		Grid grid = getGrid();

		Game.PlayerTurn Player = grid.getCoordinate(x, y).getValue();
		if(Player == Game.PlayerTurn.PLAYER1 || Player == Game.PlayerTurn.PLAYER2){
			if (y < GAME_HEIGHT - COUNT3 && x < GAME_WIDTH - COUNT3) {
				if ((grid.getCoordinate(x + 1, y + 1).getValue() == Player) && 
				       (grid.getCoordinate(x + COUNT2, y + COUNT2).getValue() ==
				       Player) && (grid.getCoordinate(x + COUNT3, y + COUNT3)
						                               .getValue() == Player)) {
					m_win.add(new Coordinate(x, y));
					m_win.add(new Coordinate(x + 1, y + 1));
					m_win.add(new Coordinate(x + COUNT2, y + COUNT2));
					m_win.add(new Coordinate(x + COUNT3, y + COUNT3));
					setWinner(Player);
				}
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::checkDiagonalDown() - END");
	}

	/**
	 * Checks upwards in a diagonal direction from the last counter that has
	 * been placed to check if there are 4 counters of the same colour in a row
	 * 
	 * \param x the x value to check \param y the y value to check
	 */
	private void checkDiagonalUp(int x, int y) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::checkDiagonalUp() - BEGIN");
		Grid grid = getGrid();

		Game.PlayerTurn Player = grid.getCoordinate(x, y).getValue();
		if(Player == Game.PlayerTurn.PLAYER1 || Player == Game.PlayerTurn.PLAYER2){
			if (y > COUNT2 && x < GAME_WIDTH - COUNT3) {
				if ((grid.getCoordinate(x + 1, y - 1).getValue() == Player)
						&& (grid.getCoordinate(x + COUNT2, y - COUNT2)
								.getValue() == Player)
						&& (grid.getCoordinate(x + COUNT3, y - COUNT3)
								.getValue() == Player)) {
					m_win.add(new Coordinate(x, y));
					m_win.add(new Coordinate(x + 1, y - 1));
					m_win.add(new Coordinate(x + COUNT2, y - COUNT2));
					m_win.add(new Coordinate(x + COUNT3, y - COUNT3));
					setWinner(Player);
				}
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::checkDiagonalUp() - END");
	}

	/**
	 * Count diagonal up right pieces from the last counter that has been placed
	 * 
	 * \param xy the piece that has been placed
	 * 
	 * \param Player check if the square is empty
	 * 
	 * \return count number of pieces
	 * 
	 */
	private int countDiagonalUp(Coordinate xy, Game.PlayerTurn Player) {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::countDiagonalUp() - BEGIN");
		int x = xy.getX();
		int y = xy.getY();
		int count = 0;
		int loopCount = 0;
		Grid grid = getGrid();
		if (Player != Game.PlayerTurn.NONE) {
			if (y > 1 && x < GAME_WIDTH - 1) {
				loopCount = 1;
			}
			if (y > COUNT2 && x < GAME_WIDTH - COUNT2) {
				loopCount = COUNT2;
			}
			if (y > COUNT3 && x < GAME_WIDTH - COUNT3) {
				loopCount = COUNT3;
			}
			for (int z = 1; z <= loopCount; z++) {
				Game.PlayerTurn Player2 = grid.getCoordinate((x + z), (y - z))
						.getValue();
				if (Player2.equals(Player)) {
					count++;
				} else {
					return count;
				}
			}
		}
		if (test || m_test)
			System.out.println("TicTacToe::countDiagonalUp() - END");
		return count;
	}

	/**
	 * Pass the turn to next player
	 * 
	 */

	protected PlayerTurn nextPlayer() {
		boolean test = false;
		if (test || m_test)
			System.out.println("TicTacToe::PlayerTurn() - BEGIN");
		if (getPlayerTurn() == Game.PlayerTurn.PLAYER1) {
			if (test || m_test)
				System.out.println("TicTacToe::PlayerTurn() - PLAYER1 turn "
				                                                 + "finished ");
			return Game.PlayerTurn.PLAYER2;
		} else {
			if (test || m_test)
				System.out.println("TicTacToe::PlayerTurn() - PLAYER2 turn "
				                                                 + "finished ");
			return Game.PlayerTurn.PLAYER1;
		}
	}

	/**
	 * calculate the player who has won the game.
	 * 
	 * \return PlayTurn the winner
	 */
	public PlayerTurn isWinner() {
		return getWinner();
	}

	/**
	 * main used to run tests which create player and a game
	 * 
	 * \throws IOException \throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException,
			IOException {
		boolean test = true;
		if (test || m_test) {
			TicTacToe game = new TicTacToe();
			Player player1 = new Human(game);
			Player player2 = new Human(game);
			player1.setPlayerName("Gavin");
			player2.setPlayerName("So");
			player1.setPlayerColour(Color.BLUE);
			player2.setPlayerColour(Color.GREEN);
			game.setPlayer1(player1);
			game.setPlayer2(player2);
			GameWindow hi = new GameWindow(game);
			game.setWindow(hi);
			Coordinate testCooor = new Coordinate(COUNT2, COUNT3,
					                                        PlayerTurn.PLAYER1);
			Coordinate testCooor2 = new Coordinate(COUNT2, COUNT3,
					                                        PlayerTurn.PLAYER2);
			game.moveMade(testCooor);
			game.moveMade(testCooor2);
			game.start();
		}
	}

	/**
	 * m_test variable used for testing when methods are entered and left and
	 * prints out into the console
	 */
	private static boolean m_test = false;
	/** TicTacToe game board size */
	private final static int GAME_WIDTH = 8;
	/** TicTacToe game board size */
	private final static int GAME_HEIGHT = 8;
	/** store the winner */
	private Game.PlayerTurn m_Winner;
	/** store the winning pieces */
	private Set<Coordinate> m_win = new HashSet<Coordinate>();
	/** use to count the chain in different direction */
	private final static int COUNT2 = 2;
	/** use to count the chain in different direction */
	private final static int COUNT3 = 3;

}
