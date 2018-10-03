
package files;

import management.IOManager;
import management.SportsManager;

public class Files {
    public static void main(String[] args) {
        // Init sports
        SportsManager.fillSportsList();
        // Check if program folder structure exists
        IOManager.makeActiveSportsFolders();
    }
}