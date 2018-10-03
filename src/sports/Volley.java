
package sports;

public class Volley extends Sport {
    private static final int MIN_PLAYERS = 5;
    private static Volley instance = new Volley();

    private Volley() {}

    public static Volley getInstance() {
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
