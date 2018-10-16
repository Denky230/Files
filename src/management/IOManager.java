
package management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

public class IOManager {
    // Separator to use when writing into / reading from files
    static String stringSeparator = ";";
    // Operative System's path separator
    static String separator = File.separator;
    static String rootPath = System.getProperty("user.dir");
    // Sports root directory's path
    static String sportsDirPath = rootPath + separator + "sports";

    /* ----------- SPORTS ----------- */

    public static void makeActiveSportsFolders() {
        // Sports directory
        File sportsDir = new File(sportsDirPath);
        // Active sports file
        String activeSportsPath = rootPath + separator + ".activeSportsFile.txt";
        File activeSportsFile = new File(activeSportsPath);

        try {
            // Check if activeSportsFile exists, if not make it
            if (!activeSportsFile.createNewFile()) {
                // Read which sports will be handled in the app
                String sportsNames = readSportsFromActiveSportsFile(activeSportsFile);
                String[] activeSports = sportsNames.split(stringSeparator);
                // Remove the ones not being handled in the app
                removeUnsupportedSports(activeSports);
            } else {
                // TO DO: Make active sports file hidden
                //java.nio.file.Files.setAttribute(Paths.get(activeSportsPath), "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);

                // Write every sport into activeSportsFile
                writeSportsIntoActiveSportsFile(activeSportsFile);
            }

            sportsDir.mkdir();
            // Create sports files based on activeSportsFile (already read)
            String sportFilePath = sportsDirPath + separator;
            for (String sport : SportsManager.getSports()) {
                new File(sportFilePath + sport).createNewFile();
            }
        } catch (IOException e) {
            System.out.println("No se ha podido crear la estructura del programa - Error: " + e);
        }
    }

    /**
     * Write which sports will be handled into activeSportsFile.
     * @param activeSportsFile file holding our sports
     */
    static void writeSportsIntoActiveSportsFile(File activeSportsFile) {
        FileWriter fw = null;

        try {
            fw = new FileWriter(activeSportsFile);

            // Make sports names string to write into activeSportsFile
            String sportsNamesString = "";
            for (String sportName : SportsManager.getSports()) {
                sportsNamesString += sportName + stringSeparator;
            }
            sportsNamesString = sportsNamesString.substring(0, sportsNamesString.length() - 1);

            // Write sports names into activeSportsFile
            fw.write(sportsNamesString);
        } catch (IOException e) {
            System.out.println("No se ha podido acceder a la estructura del programa - Error: " + e);
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (Exception e) {
                System.out.println("Ha habido un error al cerrar el archivo " + e.getMessage() + " - Error: " + e);
            }
        }
    }

    /**
     * Read which sports will be handled from activeSportsFile.
     * @param activeSportsFile file holding our sports
     */
    static String readSportsFromActiveSportsFile(File activeSportsFile) throws IOException {
        FileReader fr = new FileReader(activeSportsFile);
        BufferedReader br = new BufferedReader(fr);

        // Return sport names string
        return br.readLine();
    }

    /**
     * Remove every sport whose name is found in sportNames but not in activeSportsFile.
     * @param activeSportsNames names of sports to remove
     */
    static void removeUnsupportedSports(String[] activeSportsNames) {
        String[] sports = SportsManager.getSports();

        // Check if each sport exists in activeSportsFile, if not remove it
        for (String sport : sports) {
            boolean exists = false;
            for (String sportName : activeSportsNames) {
                if (sport.equals(sportName))
                    exists = true;
            }

            if (!exists) SportsManager.removeSport(sport);
        }
    }

    /* ----------- STUDENTS ----------- */

    /**
     * Write student info into given sport file.
     * @param studentData student's information (contains sport)
     */
    public static void signStudentIntoSport(String[] studentData) {
        // TO DO
    }
}