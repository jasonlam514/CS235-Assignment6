/**
 * \\file TicTacToeSaver.java 
 * \author -Chak Yan Lam 667271-A6
 * \date -26th April 14
 * 
 * \see FileManager.java
 * \see Saver.java
 * 
 * \brief Class to set file paths for the Saving of TicTacToe
 * 
 * This Class extends the Saver class to and controls the path of the save files
 */
public class TicTacToeSaver extends Saver{
    /**
     * Constructor to initiate the saving of the files
     * 
     * \param g - A reference to the Game to be saved
     * \param name - The game name to be saved
     */
    public TicTacToeSaver(Game g, String name) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("TicTacToeSaver :: TicTacToeSaver() BEGIN");
        }
        
        setGame(g);
        setPath(TicTacToe_PATH + name +"/");
        createDirs();
        
        if (test || m_test) {
            System.out.println("TicTacToeSaver :: TicTacToeSaver() END");
        }
    }
    
    /**
     * Test constructor
     */
    public TicTacToeSaver() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("TicTacToeSaver :: TicTacToeSaver() BEGIN");
        }
        
        setPath(TicTacToe_TEST_PATH);
        createDirs();
        
        if (test || m_test) {
            System.out.println("TicTacToeSaver :: TicTacToeSaver() END");
        }
    }
    
    /** file paths to load files */
    private final String TicTacToe_PATH = "saveData/TicTacToe/";
    /** file path to test loading */
    private final String TicTacToe_TEST_PATH = "saveDataTest/TicTacToe/";
    /** Test variable */
    private boolean m_test = false;
}
