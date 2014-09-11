/**
 * \\file OthelloLoader.java 
 * \author - Chun Kit So, Chak Yan Lam 667271-A6
 * \date -26th April 14
 * 
 * \see FileManager.java
 * \see Loader.java
 * 
 * \brief Class to set file paths for the Loading of Othello
 * 
 * This Class extends the Loader class to and controls the path of the save file
 */
public class OthelloLoader extends Loader{
    /**
     * Constructor to initiate the loading of the files
     * 
     * \param g - A reference to the Game to be loaded
     * \param name - The game path to be loaded
     */
    public OthelloLoader(Game g, String name) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloLoader :: OthelloLoader() BEGIN");
        }
        
        setGame(g);
        setPath(name);
        
        loadAll();
        
        if (test || m_test) {
            System.out.println("OthelloLoader :: OthelloLoader() END");
        }
    }
    
    /**
     * Test constructor
     * 
     * \param g - reference to the game to be loaded
     * \param s - used to overload the constructor
     */
    public OthelloLoader(Game g, int s) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloLoader :: OthelloLoader() BEGIN");
        }
        
        setGame(g);
        setPath(OTHELLO_TEST_PATH);
        
        if (test || m_test) {
            System.out.println("OthelloLoader :: OthelloLoader() END");
        }
    }
    
    /** file paths to load files */
    //private final String OTHELLO_PATH = "saveData/othello/";
    /** file path to test loading */
    private final String OTHELLO_TEST_PATH = "saveDataTest/othello/";
    /** Test variable */
    private boolean m_test = false;
}
