/**
 * \\file ConnectFourLoader.java 
 * \author -Jake Plumley, Chak Yan Lam 667271 -A6
 * \date -26th April 14
 * 
 * \see FileManager.java
 * \see Loader.java
 * 
 * \brief Class to set file paths for the Loading of ConnectFour
 * 
 * This Class extends the Loader class to and controls the path of the save file
 */
public class ConnectFourLoader extends Loader{
    /**
     * Constructor to initiate the loading of the files
     * 
     * \param game - A reference to the Game to be loaded
     * \param name - The game path to be loaded
     */
    public ConnectFourLoader(Game game, String name) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourLoader :: ConnectFourLoader() "
                                                                     + "BEGIN");
        }
        
        setGame(game);
        setPath(name);
        
        loadAll();
        
        if (test || m_test) {
            System.out.println("ConnectFourLoader :: ConnectFourLoader() END");
        }
    }
    
    /**
     * Test constructor
     * 
     * \param game - reference to the game to be loaded
     * \param s - used to overload the constructor
     */
    public ConnectFourLoader(Game game, int s) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourLoader :: ConnectFourLoader() "
                                                                     + "BEGIN");
        }
        
        setGame(game);
        setPath(CONNECTFOUR_TEST_PATH);
        
        if (test || m_test) {
            System.out.println("ConnectFourLoader :: ConnectFourLoader() END");
        }
    }
    
    /** file paths to load files */
    //private final String CONNECTFOUR_PATH = "saveData/connectfour/";
    /** file path to test loading */
    private final String CONNECTFOUR_TEST_PATH = "saveDataTest/connectfour/";
    /** Test variable */
    private boolean m_test = false;
}
