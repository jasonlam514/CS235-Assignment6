/**
 * \\file ConnectFourSaver.java 
 * \author - Jake Plumley, Chak Yan Lam 667271-A6
 * \date -26th April 14
 * 
 * \see FileManager.java
 * \see Saver.java
 * 
 * \brief Class to set file paths for the Saving of ConnectFour
 * 
 * This Class extends the Saver class to and controls the path of the save files
 */
public class ConnectFourSaver extends Saver{
    /**
     * Constructor to initiate the saving of the files
     * 
     * \param g - A reference to the Game to be saved
     * \param name - The game name to be saved
     */
    public ConnectFourSaver(Game g, String name) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourSaver :: ConnectFourSaver() BEGIN");
        }
        
        setGame(g);
        setPath(CONNECTFOUR_PATH + name +"/");
        createDirs();
        
        if (test || m_test) {
            System.out.println("ConnectFourSaver :: ConnectFourSaver() END");
        }
    }
    
    /**
     * Test constructor
     */
    public ConnectFourSaver() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourSaver :: ConnectFourSaver() BEGIN");
        }
        
        setPath(CONNECTFOUR_TEST_PATH);
        createDirs();
        
        if (test || m_test) {
            System.out.println("ConnectFourSaver :: ConnectFourSaver() END");
        }
    }
    
    /** file paths to load files */
    private final String CONNECTFOUR_PATH = "saveData/ConnectFour/";
    /** file path to test loading */
    private final String CONNECTFOUR_TEST_PATH = "saveDataTest/connectfour/";
    /** Test variable */
    private boolean m_test = false;
}
