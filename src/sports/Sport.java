
package sports;

public abstract class Sport {
    private String name;
    private int PLAYERS_PER_TEAM = 2;
    private final int MIN_PLAYERS;

    public Sport(String name) {
        this.name = name;
        this.MIN_PLAYERS = PLAYERS_PER_TEAM * 2;
    }

    public void setPlayersPerTeam(int playersPerTeam) {
        this.PLAYERS_PER_TEAM = playersPerTeam;
    }

    //public abstract boolean isReadyToPlay();
}