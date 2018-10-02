
package management;

import java.util.ArrayList;
import sports.Sport;

public class SportsManager {
    private static ArrayList<Sport> sports = new ArrayList<>();

    public static void fillSportsList() {
        // TO DO: manually add every sport
    }
    public static ArrayList<Sport> getSports() {
        return sports;
    }

    public static boolean removeSport(Sport sport) {
        return sports.remove(sport);
    }
}