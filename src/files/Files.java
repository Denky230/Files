
package files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import sports.SportsEnum;

public class Files {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        String separator = File.separator;
        String rootRoute = System.getProperty("user.dir");

        // Make sports directory
        String sportsDirRoute = rootRoute + separator + "sports";
        File sportsDir = new File(sportsDirRoute);
        sportsDir.mkdir();

        try {
            for (SportsEnum s : SportsEnum.values()) {
                new File(sportsDirRoute + separator + s).createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}