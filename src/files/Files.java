
package files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import sports.Sport;

public class Files {
    static ArrayList<Sport> sports = new ArrayList<>();

    public static void main(String[] args) {
        String separator = File.separator;
        String rootRoute = System.getProperty("user.dir");

        // Make sports directory
        String sportsDirRoute = rootRoute + separator + "sports";
        File sportsDir = new File(sportsDirRoute);

        sportsDir.mkdir();
        File file = new File(sportsDirRoute + separator + "hola.txt");

        try {
            if (!file.createNewFile()) {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}