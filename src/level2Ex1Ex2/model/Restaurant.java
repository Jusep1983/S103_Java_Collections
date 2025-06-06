package level2Ex1Ex2.model;

import level2Ex1Ex2.utils.KeyboardInput;

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
        restaurantNameExists(restaurantsScore, name);
        scoreOnRestaurantExists(restaurantsScore, name);
    }

    private static void restaurantNameExists(HashMap<String, HashSet<Integer>> restaurantsScore, String name) {
        if (restaurantsScore.containsKey(name)) {
            System.out.println("Ya existe un restaurante con nombre: " + name);
        } else {
            restaurantsScore.put(name, new HashSet<>());
            System.out.println("Se ha creado un restaurante con nombre: " + name);
        }
    }

    private static void scoreOnRestaurantExists(HashMap<String, HashSet<Integer>> restaurantsScore, String name) {
        int score = askScore();
        if (!restaurantsScore.get(name).add(score)) {
            System.out.println("La puntuación " + score + " ya existe en el restaurante " + name);
            System.out.println("Puntuación no introducida ");
        } else {
            System.out.println("La puntuación " + score + " ha sido añadida al restaurante " + name);
        }
    }

    public static void showAllDataSorted(HashMap<String, HashSet<Integer>> restaurantsScore) {
        List<String> restaurantsNames = new ArrayList<>(restaurantsScore.keySet());
        Collections.sort(restaurantsNames);
        for (String restaurant : restaurantsNames) {
            List<Integer> scores = new ArrayList<>(restaurantsScore.get(restaurant));
            Collections.sort(scores);
            Collections.reverse(scores);
            System.out.println("Nombre: " + restaurant + ", Puntuaciones: " + scores);
        }
    }

}

