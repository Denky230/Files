
package files;

import java.io.File;

import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Files {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        String separator = File.separator;
        String rootRoute = System.getProperty("user.dir");
        // SPORTS DIRECTORY
        String sportsDirRoute = rootRoute + separator + "sports";
        File sportsDir = new File(sportsDirRoute);
        // SPORTS MANAGER
        String sportsManagerRoute = rootRoute + separator + ".sportsManager.txt";
        File sportsManager = new File(sportsManagerRoute);

        // Check if folder struct exists, if not make it
        try {
            if (!sportsManager.exists()) {
                sportsManager.createNewFile();
                java.nio.file.Files.setAttribute(Paths.get(sportsManagerRoute), "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);            
            }
            if (!sportsDir.exists()) {
                sportsDir.mkdir();
                // TO DO: create sports folders
            }
        } catch (Exception e) {
            System.out.println("No se ha podido crear la estructura del programa - Error: " + e);
        }
    }
}