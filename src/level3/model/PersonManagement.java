package level3.model;

import level3.utilsIO.KeyboardInput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonManagement {
    private String filePath;
    private List<Person> persons;

    public PersonManagement() {
        this.filePath = "src" + File.separator + "level3" + File.separator + "files";
        this.persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return this.persons;
    }

    public void loadData() {
        String fullPath = this.filePath + File.separator + "persons.txt";
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
                        throw new IllegalArgumentException("Formato inválido: línea debe tener 3 campos");
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

    public String askDNI(String message) {
        return KeyboardInput.readFormatDNI(message);
    }

    public String askName(String message) {
        return KeyboardInput.readString(message);
    }

    public String askSurnames(String message) {
        return KeyboardInput.readString(message);
    }

    public Person createPerson(String idNumber, String name, String surnames) {
        return new Person(idNumber, name, surnames);
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public void writeClassification(String idNumber, String name, String surnames) {
        String fullPath = this.filePath + File.separator + "persons.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fullPath, true))) {
            String data = idNumber + "," + name + "," + surnames;  // Build the line to save
            bw.write(data);
            bw.newLine();
            System.out.println("Linia: \"" + data + "\" añadida en " + fullPath);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}
