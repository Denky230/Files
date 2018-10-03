
package management;

import java.util.ArrayList;
import sports.*;

public class SportsManager {
    private static ArrayList<Sport> sports = new ArrayList<>();

    public static ArrayList<String> getSports() {
        ArrayList<String> sportsNames = new ArrayList<>();
        for (Sport sport : sports) {
            sportsNames.add(sport.getClass().getSimpleName());
        }

        return sportsNames;
    }

    /**
     * Remove every sport whose name is found in sportNames.
     * @param sportNames names of sports to remove
     */
    public static void removeSports(String[] sportNames) {
        for (String sportString : sportNames) {
            for (Sport sport : sports) {
                if (sport.getClass().getSimpleName().equals(sportString))
                    sports.remove(sport);
            }
        }
    }
    public static boolean removeSport(Sport sport) {
        return sports.remove(sport);
    }

    // TO DO
    public static String getSportDetails() {
        return " ";
    }

    /**
     * @return "OK" if every sport is ready to be played, if not return the problems
     */
    public static String checkSportsState() {
        String state = "OK";
        for (Sport sport : sports) {
            if (!sport.isReadyToPlay().equals("OK")) {
                // TO DO: Add sport problems to state
            }
        }

        return state;
    }

    public static void fillSportsList() {
        sports.add(Volley.getInstance());
        sports.add(Basket.getInstance());
    }
}