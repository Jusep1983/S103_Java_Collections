package level1Ex3.mainRunner;

import level1Ex3.exceptions.RouteNotFoundException;
import level1Ex3.model.GameManagement;

public class RunMain {
    public static void runMain() throws RouteNotFoundException {
        GameManagement start = new GameManagement();
        try {
            checkFileExists(start);
        } catch (RouteNotFoundException e) {
            System.out.println("Error, " + e.getMessage());
            System.out.println("The game could not be started.");
        }
    }

    private static void checkFileExists(GameManagement start) {
        if (start.fileExists()) {
            start.loadData();
            start.game();
        } else {
            throw new RouteNotFoundException("file not found.");
        }
    }
}
