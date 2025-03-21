package level2Ex1Ex2.controller;

import level2Ex1Ex2.data.DataSample;
import level2Ex1Ex2.model.Restaurant;
import level2Ex1Ex2.utilsIO.KeyboardInput;

import java.util.HashMap;
import java.util.HashSet;

public class RunMain {

    public static void startApp(HashMap<String, HashSet<Integer>> restaurantsScore){

        DataSample.loadData(restaurantsScore);

        boolean exit = false;
        do {
            int option = KeyboardInput.readIntegerBetweenOnRange("""
                    --------------------------------------------
                      MENÚ
                    --------------------------------------------
                    1.- Introduce puntuación a Restaurante
                    2._ Mostrar restaurantes y sus puntuaciones
                    0.- Salir aplicación
                    Introduce un número de opción valida entre 0 y 2: 
                    """, 0, 2);
            switch (option) {
                case 1:
                    Restaurant.addScoreRestaurant(restaurantsScore);
                    break;
                case 2:
                    Restaurant.showAllDataSorted(restaurantsScore);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Gracias por utilizar la aplicación!\nHasta pronto...");
                    break;
            }
        } while (!exit);
    }
}
