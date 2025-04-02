package level3.services;

import level3.model.Person;
import level3.utilsIO.InputOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonManagement {
    private final String FILE_PATH;
    private List<Person> persons;

    public PersonManagement() {
        this.FILE_PATH = "src" + File.separator + "level3" + File.separator + "files";
        this.persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return this.persons;
    }

    public String getFILE_PATH() {
        return this.FILE_PATH;
    }

    public void loadData() {
        String fullPath = this.FILE_PATH + File.separator + "persons.csv";
        int numberLine = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(fullPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] parts = line.split(",", 3);
                    if (parts.length == 3) {
                        String idNumber = parts[0].trim();
                        String name = parts[1].trim();
                        String lastName = parts[2].trim();
                        Person person = new Person(idNumber, name, lastName);
                        this.persons.add(person);
                    } else {
                        System.out.println("Formato inválido: línea " + numberLine + " debe tener 3 campos");
                    }
                }
                numberLine++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + fullPath + " " + e.getMessage());
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Error, linia " + numberLine + " no cargada del archivo "
                               + fullPath + " \n" + e.getMessage());
        }
    }

    public boolean dniExists(String dni) {
        boolean exists = false;
        int i = 0;
        while (i < this.persons.size() && !exists) {
            if (dni.equalsIgnoreCase(this.persons.get(i).getIdNumber())) {
                exists = true;
            }
            i++;
        }
        return exists;
    }

    private String askDNI() {
        return InputOutput.readFormatDNI("Introduce DNI de la persona: ");
    }

    private String askName() {
        return InputOutput.readString("Introduce el nombre de la persona: ");
    }

    private static String askSurnames() {
        return InputOutput.readString("Introduce dos apellidos de la persona, separados por un espacio: ");
    }

    private Person createPerson(String idNumber, String name, String surnames) {
        return new Person(idNumber, name, surnames);
    }

    private void addPerson(Person person) {
        this.persons.add(person);
    }

    public void registerPerson() {
        System.out.println("( Ejemplos de DNI correctos: 12345678Z 87654321X 11223344B 74246722P 55667788Z 39383352S 69967049Z )");
        String idNumber = askDNI();
        if (dniExists(idNumber)) {
            System.out.println("Error, ya existe una persona con dni " + idNumber +
                               "\nNo se ha podido introducir la persona");
        } else {
            String name = askName();
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            String surnames = formatedSurnames();
            Person person = createPerson(idNumber, name, surnames);
            addPerson(person);
            String fullPath = getFILE_PATH() + File.separator + "persons.csv";
            InputOutput.writePersonOnFile(idNumber, name, surnames, fullPath);
            System.out.println(person + " añadida correctamente");
        }
    }

    private static String formatedSurnames() {
        String[] surnameArray;
        String surnames;
        do {
            surnames = askSurnames();
            surnameArray = surnames.toLowerCase().split("\\s+");
            if (surnameArray.length != 2) {
                System.out.println("Solo se admiten dos apellidos y separados por un espacio");
            }
        } while (surnameArray.length != 2);
        for (int i = 0; i < surnameArray.length; i++) {
            surnameArray[i] = surnameArray[i].substring(0, 1).toUpperCase() + surnameArray[i].substring(1);
        }
        surnames = String.join(" ", surnameArray);
        return surnames;
    }

}
