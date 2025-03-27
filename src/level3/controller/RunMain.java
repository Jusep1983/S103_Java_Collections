package level3.controller;

import level3.model.Person;
import level3.model.PersonManagement;
import level3.utilsIO.InputOutput;

import java.util.Comparator;

public class RunMain {
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
                    RunMain.registerPerson(personManagement);
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

    private static void registerPerson(PersonManagement personManagement) {
        System.out.println("( Ejemplos de DNI correctos: 12345678Z 87654321X 11223344B 74246722P 55667788Z 39383352S 69967049Z )");
        String idNumber = personManagement.askDNI("Introduce DNI de la persona: ");
        if (personManagement.dniExists(idNumber)) {
            System.out.println("Error, ya existe una persona con dni " + idNumber +
                               "\nNo se ha podido introducir la persona");
        } else {
            String name = personManagement.askName("Introduce el nombre de la persona: ");
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            String surnames = personManagement.askSurnames(
                    "Introduce los apellidos de la persona, separados por un espacio: ");
            surnames = surnames.substring(0, 1).toUpperCase() + surnames.substring(1).toLowerCase();
            Person person = personManagement.createPerson(idNumber, name, surnames);
            personManagement.addPerson(person);
            InputOutput.writeClassification(idNumber, name, surnames, personManagement.getFilePath());
            System.out.println(person + " añadida correctamente");
        }
    }
}
