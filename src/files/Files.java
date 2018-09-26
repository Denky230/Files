
package files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Files {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        String separator = File.separator;
        String rootRoute = System.getProperty("user.dir");

        // Make sports directory
        String sportsDirRoute = rootRoute + separator + "sports";
        File sportsDir = new File(sportsDirRoute);
        sportsDir.mkdir();

        // Make sport file
        File sportFile = new File(sportsDirRoute + separator + "hola.txt");

        try {
            if (!sportFile.createNewFile()) {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}