
package management;

import java.util.ArrayList;
import sports.*;

public class SportsManager {
    private static ArrayList<Sport> sports = new ArrayList<>();

    /**
     * TEST
     * Sout sports
     */
    public static void soutSports() {
        for (Sport s : sports) {
            System.out.print(s.getClass().getSimpleName() + " ");
        }
    }

    /**
     * @return array of sports names as strings
     */
    public static String[] getSports() {
        String[] sportsNames = new String[sports.size()];
        for (int i = 0; i < sportsNames.length; i++) {
            sportsNames[i] = sports.get(i).getClass().getSimpleName();
        }

        return sportsNames;
    }

    /**
     * Remove sport if its name is found in sportNames.
     * @param sportName names of sports to remove
     */
    public static boolean removeSport(String sportName) {
        for (Sport sport : sports) {
            if (sport.getClass().getSimpleName().equals(sportName))
                return sports.remove(sport);
        }

        return false;
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

    /**
     * Initialize all the sports originally handled.
     * Add here newly implemented sports.
     */
    public static void fillSportsList() {
        sports.add(Volley.getInstance());
        sports.add(Basket.getInstance());
    }
}