package level2Ex1Ex2.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DataSample {

    public static void loadData(HashMap<String, HashSet<Integer>> restaurantsScore) {
        restaurantsScore.put("Pizza Luigi", new HashSet<>(Set.of(1, 2, 3, 4)));
        restaurantsScore.put("Joselito´s ", new HashSet<>());
        restaurantsScore.get("Joselito´s ").add(5);
        restaurantsScore.put("Armetera bar ", new HashSet<>(Set.of(5, 1)));
    }

}
