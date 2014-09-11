/**
 * \\file Coordinate.Java 
 * \author -B. Golightly (659715) 
 * \date -12/02/2014
 * 
 * \brief Coordinate objects are used to hold information about one individual
 * point in the game board.
 * 
 * Such as an Othello square, TicTacToe or Connect Four place. 
 * They contain X and Y values
 * to identify their position in game/logical (not pixel) space, and may also
 * contain a value that, if set, contains information to identify the owner of
 * the point. A coordinate may be owned by the grid, or simply a holder for
 * information about a grid location that can be easily "committed" - for
 * example see the Game class which iterates over an ArrayList of Coordinates
 * that represent the result of a move according to given game rules.
 */

public class Coordinate {
	/**
	 * SetValue 
	 * \param value Any valid player enum.
	 */
	public void setValue(Game.PlayerTurn value) {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: setValue() BEGIN");
		}
		m_Value = value;

		if (test || m_test) {
			System.out.println("Coordinate :: setValue() END");
		}
	}

	/**
	 * Query the logical horizontal position of the coordinate 
	 * \return The coordinate's x value.
	 */
	public int getX() {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: getX() BEGIN");
		}

		if (test || m_test) {
			System.out.println("Coordinate :: getX() END");
		}
		return m_X;
	}

	/**
	 * Query the logical vertical position of the coordinate 
	 * \return The coordinate's y value.
	 */
	public int getY() {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: getY() BEGIN");
		}

		if (test || m_test) {
			System.out.println("Coordinate :: getY() END");
		}
		return m_Y;
	}

	/**
	 * Coordinate constructor 
	 * \param x The horizontal position of the coordinate ranging from 0 to the
	 *  grid logical width minus one. 
	 * \param y The vertical position of the coordinate ranging from 0 to the 
	 *  grid logical height minus one. 
	 * \return A coordinate initialised with a default zero value.
	 */
	public Coordinate(int x, int y) {
		this(x, y, Game.PlayerTurn.NONE);
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: Coordinate() BEGIN");
		}

		if (test || m_test) {
			System.out.println("Coordinate :: Coordinate() END");
		}

	}

	/**
	 * Coordinate constructor 
	 * \param x The horizontal position of the coordinate ranging from 0 to the
	 *  grid logical width minus one. 
	 * \param y The vertical position of the coordinate ranging from 0 to the
	 *  grid logical height minus one. 
	 * \param value Any valid player enum. 
	 * \return A coordinate initialised to the specified values.
	 */
	public Coordinate(int x, int y, Game.PlayerTurn value) {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: Coordinate() BEGIN");
		}
		if (x < 0) {
			throw new IllegalArgumentException("Illegal X argument " + x);
		}
		if (y < 0) {
			throw new IllegalArgumentException("Illegal Y argument " + y);
		}

		m_X = x;
		m_Y = y;
		m_Value = value;

		if (test || m_test) {
			System.out.println("Coordinate :: Coordinate() END");
		}
	}

	/**
	 * Coordinate constructor 
	 * \param c Coordinate to duplicate. 
	 * \return A coordinate initialised as a copy of an existing coordinate.
	 */
	public Coordinate(Coordinate c) {
		this(c.getX(), c.getY(), c.getValue());
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: Coordinate() BEGIN");
		}

		if (test || m_test) {
			System.out.println("Coordinate :: Coordinate() END");
		}
	}

	/**
	 * Query the set value of the coordinate 
	 * \return The coordinate's current value.
	 */
	public Game.PlayerTurn getValue() {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: getValue() BEGIN");
		}

		if (test || m_test) {
			System.out.println("Coordinate :: getValue() END");
		}
		return m_Value;
	}

	/**
	 * Query if a coordinate value equals a certain value 
	 * \return True if it  does.
	 */
	public boolean equals(Game.PlayerTurn value) {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: equals() BEGIN");
		}

		if (test || m_test) {
			System.out.println("Coordinate :: equals() END");
		}
		return (m_Value == value);
	}

	/**
	 * Query if a coordinate value equals a certain value 
	 * \return True if it doesn't.
	 */
	public boolean notEquals(Game.PlayerTurn value) {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: notEquals() BEGIN");
		}

		if (test || m_test) {
			System.out.println("Coordinate :: notEquals() END");
		}
		return (m_Value != value);
	}

	/**
	 * Query if a coordinate value represents the empty value 
	 * \return True if it does.
	 */
	public boolean isEmpty() {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: isEmpty() BEGIN");
		}

		if (test || m_test) {
			System.out.println("Coordinate :: isEmpty() END");
		}
		return (m_Value != Game.PlayerTurn.PLAYER1 && m_Value != 
		                                               Game.PlayerTurn.PLAYER2);
	}

	/**
	 * Query if a coordinate value represents a non-empty value 
	 * \return True if it does.
	 */
	public boolean isFilled() {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: isFilled() BEGIN");
		}

		if (test || m_test) {
			System.out.println("Coordinate :: isFilled() END");
		}
		return (m_Value == Game.PlayerTurn.PLAYER1 || m_Value == 
		                                               Game.PlayerTurn.PLAYER2);
	}

	/**
	 * Translate the position of a coordinate 
	 * \param x distance to move horizontally 
	 * \param y distance to move vertically
	 */
	public void move(int x, int y) {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: move() BEGIN");
		}
		// used by Othello class to iterate in a direction
		// when capturing peices or checking if a move
		// is valid.
		m_X += x;
		m_Y += y;

		if (test || m_test) {
			System.out.println("Coordinate :: move() END");
		}
	}

	/**
	 * Query if a coordinate lies within a certain range 
	 * \param x0 Start x position (inclusive/left-bounded) 
	 * \param y0 Start y position (inclusive/left-bounded) 
	 * \param x1 End x position (exclusive/right-open)
	 * \param y1 End y position (exclusive/right-open) 
	 * \return True if it does.
	 */
	public boolean within(int x0, int y0, int x1, int y1) {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: within() BEGIN");
		}
		// x1/y1 are right-open

		if (test || m_test) {
			System.out.println("Coordinate :: within() END");
		}
		return ((m_X >= x0) && (m_Y >= y0) && (m_X < x1) && (m_Y < y1));
	}

	/**
	 * Construct a string representation of a coordinate for debugging purposes.
	 * \return A string representation of a coordinate
	 */
	public String toString() {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: toString() BEGIN");
		}

		if (test || m_test) {
			System.out.println("Coordinate :: toString() END");
		}
		return "Coordinate(" + m_X + ", " + m_Y + ", " + m_Value + ")";
	}

	/**
	 * Override hashCode to modify the equality definition of Coordinate objects
	 * \return Any integer do not affect the testing of equality
	 */
	@Override
	public int hashCode() {
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: hashCode() BEGIN");
		}

		if (test || m_test) {
			System.out.println("Coordinate :: hashCode() END");
		}
		return m_X + m_Y;
	}

	/**
	 * Override equals to modify the equality definition of Coordinate objects
	 * for storing in a set 
	 * \return true if the XY position of two coordinates are the same, 
	 * otherwise return false
	 */
	@Override
	public boolean equals(Object obj){
		boolean test = false;
		if (test || m_test) {
			System.out.println("Coordinate :: equals() BEGIN");
        }
		
		
		if(obj instanceof Coordinate && m_Y == ((Coordinate) obj).getY() 
				&& m_X == ((Coordinate) obj).getX()){
			
			if (test || m_test) {
	            System.out.println("Coordinate :: equals() END");
	            }
		return true;
	}else{
		if (test || m_test) {
            System.out.println("Coordinate :: equals() END");
            }
		return false;
		}
	}

	public static void main(String args[]) {
		int testX = 123;
		int testY = 456;
		int textXTwo = 5;
		int testYTwo = 10;
		/**Test case 1 (Constructor)*/
		Coordinate c = new Coordinate(123,456,Game.PlayerTurn.PLAYER2);
		if(c.getX() == testX)
			System.out.println("Correct X value set");
		if(c.getY() == testY)
			System.out.println("Correct Y value set");
		if(c.getValue() == Game.PlayerTurn.PLAYER2)
			System.out.println("Correct Player turn set");
		
		Coordinate c2 = new Coordinate(textXTwo,textXTwo);
		if(c2.within(0,0,testYTwo,testYTwo) == true)
			System.out.println("Tested within bounds");
		if(c2.within(0, 0, textXTwo, textXTwo) == false)
			System.out.println("Tested within bounds");
		
	}

	/** X Coordinate value*/
	private int m_X;
	/** Y Coordinate value*/
	private int m_Y;
	/**Stored Players turn*/
	private Game.PlayerTurn m_Value;
	/**For testing purposes, for speed keep at false*/
	private boolean m_test = false;
}
