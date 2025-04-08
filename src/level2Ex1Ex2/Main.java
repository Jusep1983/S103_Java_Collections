package level2Ex1Ex2;

import level2Ex1Ex2.application.ApplicationLauncher;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, HashSet<Integer>> restaurantsScore = new HashMap<>();

        ApplicationLauncher.startApp(restaurantsScore);

    }

}
