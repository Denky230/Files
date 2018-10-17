
package sports;

public class Football extends Sport {
    private static final int MIN_PLAYERS = 10;
    private static Football instance = new Football();

    private Football() {};

    public static Football getInstance() {
        return instance;
    }

    @Override
    public String isReadyToPlay() {
        return "OK";
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
