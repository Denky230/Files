
package management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

public class IOManager {
    // Separator to use when writing into / reading from files
    static String stringSeparator = ";";

    public static void makeActiveSportsFolders() {
        String separator = File.separator;
        String rootRoute = System.getProperty("user.dir");
        // SPORTS DIRECTORY
        String sportsDirRoute = rootRoute + separator + "sports";
        File sportsDir = new File(sportsDirRoute);
        // ACTIVE SPORTS
        String activeSportsRoute = rootRoute + separator + ".activeSportsFile.txt";
        File activeSportsFile = new File(activeSportsRoute);

        /* TEST - Start app brand new 
        System.out.println(""
                + "ActiveSports file: " + activeSportsFile.delete() + "\n"
                + "SportsDir: " + sportsDir.delete()
        );*/

        // Check if folder struct exists, if not make it
        if (!activeSportsFile.exists()) {
            // TO DO: Move this whole new file creation to a separate function
            // Make activeSportsFile which will contain every sport handled
            try {
                activeSportsFile.createNewFile();
                // TO DO: Make active sports file hidden
                //java.nio.file.Files.setAttribute(Paths.get(activeSportsRoute), "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
            } catch (Exception e) {
                System.out.println("Mal");
            }

            // Write every sport into activeSportsFile
            writeSportsIntoActiveSportsFile(activeSportsFile);
        } else {
            // TO DO: Read which sports to use in the app
            String sportNames = readSportsFromActiveSportsFile(activeSportsFile);
            // Remove the ones not being used in the app
            removeNonsupportedSports(sportNames.split(stringSeparator));
        }
        if (!sportsDir.exists()) {
            sportsDir.mkdir();
            // TO DO: create sports folders based on activeSportsFile (already read)
        }
    }

    /**
     * Write which sports will be handled into activeSportsFile
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

            fw.write(sportsNamesString);
        } catch (IOException e) {
            System.out.println("No se ha podido crear la estructura para el programa - Error: " + e);
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
     * Read which sports will be handled from activeSportsFile
     * @param activeSportsFile file holding our sports
     */
    static String readSportsFromActiveSportsFile(File activeSportsFile) {
        FileReader fr = null;

        try {
            fr = new FileReader(activeSportsFile);
            BufferedReader br = new BufferedReader(fr);

            // Return sport names string
            return br.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo a leer no se ha encontrado");
        } catch (IOException e) {
            System.out.println("Ha habido un error al leer del archivo " + e.getMessage() + " - Error: " + e);
        }

        return "";
    }

    /**
     * Remove every sport whose name is found in sportNames but not in activeSportsFile.
     * @param sportNames names of sports to remove
     */
    public static void removeUnsupportedSports(String[] sportNames) {
        // TO DO: Substract getSports() - sportNames
    }

    static void removeNonsupportedSports(String[] sportNames) {
        for (String name : sportNames) {
            for (String sportName : SportsManager.getSports()) {

            }
        }
    }
}