
package management;

import files.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

public class IOManager {
    // Separator to use when writing into / reading from files
    static final String STRING_SEPARATOR = ";";
    // Operative System's path separator
    static final String PATH_SEPARATOR = File.separator;
    static final String ROOT_PATH = System.getProperty("user.dir");
    // Sports root directory's path
    static final String SPORTS_DIRECTORY_PATH = ROOT_PATH + PATH_SEPARATOR + "sports";
    // Active sports file
    static final String ACTIVESPORTS_FILE_PATH = ROOT_PATH + PATH_SEPARATOR + ".activeSportsFile.txt";
    static File activeSportsFile = new File(ACTIVESPORTS_FILE_PATH);

    /* ----------- SPORTS ----------- */

    public static void makeActiveSportsFolders() {
        // Sports directory
        File sportsDir = new File(SPORTS_DIRECTORY_PATH);

        try {
            // Check if activeSportsFile exists, if not make it
            if (!activeSportsFile.createNewFile()) {
                // Read which sports will be handled in the app
                String sportsNames = readSportsFromActiveSportsFile(activeSportsFile);
                String[] activeSports = sportsNames.split(STRING_SEPARATOR);
                // Remove the ones not being handled in the app
                removeUnsupportedSports(activeSports);
            } else {
                // TO DO: Make active sports file hidden
                //java.nio.file.Files.setAttribute(Paths.get(ACTIVESPORTS_FILE_PATH), "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);

                // Write every sport into activeSportsFile
                writeSportsIntoActiveSportsFile();
            }

            sportsDir.mkdir();
            // Create sports files based on activeSportsFile (already read)
            String sportFilePath = SPORTS_DIRECTORY_PATH + PATH_SEPARATOR;
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
    public static void writeSportsIntoActiveSportsFile() {
        FileWriter fw = null;

        try {
            fw = new FileWriter(activeSportsFile);

            // Make sports names string to write into activeSportsFile
            String sportsNamesString = "";
            for (String sportName : SportsManager.getSports()) {
                sportsNamesString += sportName + STRING_SEPARATOR;
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
     * Write student info into given sport's file.
     * @param studentData student's information (contains sport)
     */
    public static void signStudentIntoSport(Student studentData) {
        // TO DO
        String sportFilePath = SPORTS_DIRECTORY_PATH + STRING_SEPARATOR + studentData.getSport();
        
        FileWriter fw = null;

        try {
            fw = new FileWriter(sportFilePath);
            
            // Write sports names into activeSportsFile
            //fw.write(sportsNamesString);
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
}