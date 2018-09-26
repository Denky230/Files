
package sports;

public abstract class Sport {
    private int PLAYERS_PER_TEAM = 2;
    private final int MIN_PLAYERS;

    public Sport() {
        this.MIN_PLAYERS = PLAYERS_PER_TEAM * 2;
    }

    //public abstract boolean isReadyToPlay();
}