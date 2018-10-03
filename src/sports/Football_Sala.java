
package sports;

public class Football_Sala extends Sport {
    private static final int MIN_PLAYERS = 10;  // TO DO: check what this value has to be
    private static Football_Sala instance = new Football_Sala();

    private Football_Sala() {};

    public static Football_Sala getInstance() {
        return instance;
    }

    @Override
    public String isReadyToPlay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
