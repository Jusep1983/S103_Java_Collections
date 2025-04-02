package level3.utilsIO;

import level3.exceptions.EmptyInputException;
import level3.exceptions.IncorrectNameException;
import level3.exceptions.ValueOutOfRangeException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputOutput {

    private static final Scanner SC = new Scanner(System.in);

    public static void numberNotEmpty(String input) throws EmptyInputException {
        if (input.isEmpty()) {
            throw new EmptyInputException("el campo no puede estar vacío");
        }
    }

    public static void checkRangeNumber(String input, int minimum, int maximum) throws ValueOutOfRangeException {
        int number = Integer.parseInt(input);
        if (number < minimum || number > maximum) {
            throw new ValueOutOfRangeException(
                    "el valor introducido ha de estar entre " + minimum + " y " + maximum + ". "
            );
        }
    }

    public static int readIntegerBetweenOnRange(String message, int minimum, int maximum) {
        while (true) {
            try {
                System.out.print(message);
                String input = SC.nextLine();
                numberNotEmpty(input);
                checkRangeNumber(input, minimum, maximum);
                return Integer.parseInt(input);
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Error de formato");
            } catch (EmptyInputException | NoSuchElementException | IllegalStateException |
                     ValueOutOfRangeException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    public static String readANonEmptyString(String message) {
        while (true) {
            try {
                System.out.print(message);
                return checkStringNotEmpty();
            } catch (EmptyInputException | NoSuchElementException | IllegalStateException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    public static String checkStringNotEmpty() throws EmptyInputException {
        String inputStr = SC.nextLine().trim();
        if (inputStr.isEmpty()) {
            throw new EmptyInputException("el nombre no puede estar vacío");
        } else {
            return inputStr;
        }
    }

    public static String checkString() throws EmptyInputException {
        String inputStr = SC.nextLine().trim();
        if (inputStr.isEmpty()) {
            throw new EmptyInputException("el nombre no puede estar vacío");
        } else if (inputStr.matches(".*\\d.*")) {
            throw new IncorrectNameException("el nombre no puede contener números");
        } else {
            return inputStr;
        }
    }

    public static String readString(String message) {
        while (true) {
            try {
                System.out.print(message);
                return checkString();
            } catch (EmptyInputException | IncorrectNameException | NoSuchElementException | IllegalStateException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    public static void writePersonOnFile(String idNumber, String name, String surnames, String fullPath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fullPath, true))) {
            String data = idNumber + "," + name + "," + surnames;  // Build the line to save
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static String readFormatDNI(String message) {
        String dniStr;
        do {
            dniStr = InputOutput.readANonEmptyString(message);
            dniStr = dniStr.toUpperCase().trim().replaceAll("[^A-Z0-9]", "");
        } while (!isValidDniFormat(dniStr));
        return dniStr;
    }

    private static boolean isValidDniFormat(String dniStr) {
        return isValidLengthDniFormat(dniStr)
               && isValidNumbersDniFormat(dniStr)
               && isValidLetterDniFormat(dniStr);
    }

    private static boolean isValidLengthDniFormat(String dniStr) {
        if (dniStr.length() != 9) {
            System.out.println("Un DNI debe tener 9 caracteres: 8 números y 1 letra.");
            return false;
        } else {
            return true;
        }
    }

    private static boolean isValidNumbersDniFormat(String dniStr) {
        String numbers = dniStr.substring(0, 8);
        if (!numbers.chars().allMatch(Character::isDigit)) {
            System.out.println("Un DNI debe tener 9 caracteres: 8 números y 1 letra.");
            return false;
        } else {
            return true;
        }
    }

    private static boolean isValidLetterDniFormat(String dniStr) {
        String numbers = dniStr.substring(0, 8);
        char letter = dniStr.charAt(8);
        if (getExpectedDniLetter(Integer.parseInt(numbers)) != letter) {
            System.out.println("La letra del DNI introducido es incorrecta.");
            return false;
        } else {
            return true;
        }
    }

    private static char getExpectedDniLetter(int dniNumber) {
        final char[] lettersDni = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
                'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return lettersDni[dniNumber % 23];
    }

}
