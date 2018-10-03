
package sports;

public class Badminton extends Sport {
    private static final int MIN_PLAYERS = 10;  // TO DO: check what this value has to be
    private static Badminton instance = new Badminton();

    private Badminton() {}

    public static Badminton getInstance() {
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
