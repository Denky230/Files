
package sports;

public class Basket extends Sport {
    private static final int MIN_PLAYERS = 10;  // TO DO: check what this value has to be
    private static Basket instance = new Basket();

    private Basket() {}

    public static Basket getInstance() {
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