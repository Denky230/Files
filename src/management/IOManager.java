
package management;

import java.io.File;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

public class IOManager {

    public void makeActiveSportsFolders() {
        String separator = File.separator;
        String rootRoute = System.getProperty("user.dir");
        // SPORTS DIRECTORY
        String sportsDirRoute = rootRoute + separator + "sports";
        File sportsDir = new File(sportsDirRoute);
        // ACTIVE SPORTS FILE
        String activeSportsRoute = rootRoute + separator + ".activeSports.txt";
        File activeSports = new File(activeSportsRoute);

        // Check if folder struct exists, if not make it
        try {
            if (!activeSports.exists()) {
                activeSports.createNewFile();
                // Make active sports file hidden
                java.nio.file.Files.setAttribute(Paths.get(activeSportsRoute), "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
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
