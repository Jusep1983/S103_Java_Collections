package level2Ex1Ex2.model;

import level2Ex1Ex2.utilsIO.KeyboardInput;

import java.util.*;

public class Restaurant {
    private String name;
    private int score;

    public Restaurant(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static String askRestaurant() {
        return KeyboardInput.readString("Introduce el nombre del restaurante: ");
    }

    public static int askScore() {
        return KeyboardInput.readIntegerBetweenOnRange("Introduce una puntuación para entre 1 y 5: ", 1, 5);
    }

    public static void addScoreRestaurant(HashMap<String, HashSet<Integer>> restaurantsScore) {
        String name = askRestaurant();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        // If the restaurant does not exist, we create it.
        if (!restaurantsScore.containsKey(name)) {
            restaurantsScore.put(name, new HashSet<>());
            System.out.println("Se ha creado un restaurante con nombre: " + name);
        } else {
            System.out.println("Ya existe un restaurante con nombre: " + name);
        }
        int score = askScore();
        boolean addScore = restaurantsScore.get(name).add(score);
        if (addScore) {
            System.out.println("La puntuación " + score + " ha sido añadida al restaurante " + name);
        } else {
            System.out.println("La puntuación " + score + " ya existe en el restaurante " + name);
            System.out.println("Puntuación no introducida ");
        }

    }

    public static void showAllDataSorted(HashMap<String, HashSet<Integer>> restaurantsScore) {
        List<String> restaurantsNames = new ArrayList<>(restaurantsScore.keySet());
        for (String restaurant : restaurantsNames) {
            List<Integer> scores = new ArrayList<>(restaurantsScore.get(restaurant));
            Collections.sort(scores);
            Collections.reverse(scores);
            System.out.println("Nombre: " + restaurant + ", Puntuaciones: " + scores);
        }
    }
}

/// / Convert HashMap to TreeMap to sort by key alphabetically
//TreeMap<String, HashSet<Integer>> sortedMap = new TreeMap<>(restaurantsScore);
//
//        for (Map.Entry<String, HashSet<Integer>> entry : sortedMap.entrySet()) {
//String restaurant = entry.getKey();// Get the key
//TreeSet<Integer> sortedScores = new TreeSet<>(Collections.reverseOrder());
//            sortedScores.addAll(entry.getValue());// Get the value
//        System.out.println("Name: " + restaurant + ", scores:  " + sortedScores);
