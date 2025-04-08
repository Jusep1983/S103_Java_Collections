package level3.application;

import level3.model.Person;
import level3.services.PersonManagement;
import level3.utilsIO.InputOutput;

import java.util.Comparator;

public class ApplicationLauncher {
    public static void startApp() {
        PersonManagement personManagement = new PersonManagement();
        personManagement.loadData();
        boolean exit = false;
        do {
            int option = InputOutput.readIntegerBetweenOnRange("""
                    ------------------------------------------------------
                     MENÚ PERSONAS
                    ------------------------------------------------------
                    1- Introducir persona.
                    2- Mostrar las personas ordenadas por nombre (A-Z).
                    3- Mostrar las personas ordenadas por nombre (Z-A).
                    4- Mostrar las personas ordenadas por apellidos (A-Z).
                    5- Mostrar las personas ordenadas por apellidos (Z-A).
                    6- Mostrar las personas ordenadas por DNI (1-9).
                    7- Mostrar las personas ordenadas por DNI (9-1).
                    0- Salir.
                    Introduce una opción valida entre 0 y 7:
                    """, 0, 8);

            switch (option) {
                case 1:
                    personManagement.registerPerson();
                    break;
                case 2:
                    personManagement.getPersons().sort(Comparator.comparing(Person::getName));
                    personManagement.getPersons().forEach(System.out::println);
                    break;
                case 3:
                    personManagement.getPersons().sort(Comparator.comparing(Person::getName).reversed());
                    personManagement.getPersons().forEach(System.out::println);
                    break;
                case 4:
                    personManagement.getPersons().sort(Comparator.comparing(Person::getSurnames));
                    personManagement.getPersons().forEach(System.out::println);
                    break;
                case 5:
                    personManagement.getPersons().sort(Comparator.comparing(Person::getSurnames).reversed());
                    personManagement.getPersons().forEach(System.out::println);
                    break;
                case 6:
                    personManagement.getPersons().sort(Comparator.comparing(Person::getIdNumber));
                    personManagement.getPersons().forEach(System.out::println);
                    break;
                case 7:
                    personManagement.getPersons().sort(Comparator.comparing(Person::getIdNumber).reversed());
                    personManagement.getPersons().forEach(System.out::println);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Gracias por utilizar la aplicación!\nHasta pronto...");
                    break;
            }
        } while (!exit);
    }

}
