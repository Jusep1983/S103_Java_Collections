package level3.utilsIO;

import level3.exceptions.EmptyInputException;
import level3.exceptions.IncorrectNameException;
import level3.exceptions.ExceptionValueOutOfRange;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputOutput {
    private static final Scanner SC = new Scanner(System.in);

    public static int readIntegerBetweenOnRange(String message, int minimum, int maximum) {
        int number = 0;
        boolean correct = false;
        do {
            System.out.print(message);
            try {
                number = SC.nextInt();
                if (number < minimum || number > maximum) {
                    throw new ExceptionValueOutOfRange(
                            "el valor introducido ha de estar entre " + minimum + " y " + maximum + ". "
                    );
                } else {
                    correct = true;
                }
            } catch (ExceptionValueOutOfRange e) {
                System.out.println("Error, " + e.getMessage());
            } catch (InputMismatchException ex) {
                System.out.println("Error de formato");
            }
            SC.nextLine();
        } while (!correct);
        return number;
    }

    public static String readANonEmptyString(String message) {
        String text = "";
        boolean correct = false;
        do {
            System.out.print(message);
            try {
                text = SC.nextLine().trim();
                if (text.isEmpty()) {
                    System.out.println("Error, el campo no puede quedar en blanco.");
                } else {
                    correct = true;
                }
            } catch (Exception ex) {
                System.out.println("Error en la introducción del string.");
            }
        } while (!correct);
        return text;
    }

    public static String readString(String message) {
        String inputStr = "";
        boolean correct = false;
        do {
            System.out.print(message);
            try {
                inputStr = SC.nextLine().trim();
                if (inputStr.matches(".*\\d.*")) {
                    throw new IncorrectNameException("el nombre no puede contener números");
                }
                if (inputStr.isEmpty()) {
                    throw new EmptyInputException("el nombre no puede estar vacío");
                }
                correct = true;
            } catch (EmptyInputException | IncorrectNameException e) {
                System.out.println("Error, " + e.getMessage());
            }
        } while (!correct);
        return inputStr;
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
        boolean isValid = false;
        if (dniStr.length() != 9) {
            System.out.println("Un DNI debe tener 9 caracteres: 8 números y 1 letra.");
        } else {
            isValid = true;
        }
        return isValid;
    }

    private static boolean isValidNumbersDniFormat(String dniStr) {
        boolean isValid = false;
        String numbers = dniStr.substring(0, 8);
        if (!numbers.chars().allMatch(Character::isDigit)) {
            System.out.println("Un DNI debe tener 9 caracteres: 8 números y 1 letra.");
        } else {
            isValid = true;
        }
        return isValid;
    }

    private static boolean isValidLetterDniFormat(String dniStr) {
        boolean isValid = false;
        String numbers = dniStr.substring(0, 8);
        char letter = dniStr.charAt(8);
        if (getExpectedDniLetter(Integer.parseInt(numbers)) != letter) {
            System.out.println("La letra del DNI introducido es incorrecta.");
        } else {
            isValid = true;
        }
        return isValid;
    }

    private static char getExpectedDniLetter(int dniNumber) {
        final char[] lettersDni = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
                'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return lettersDni[dniNumber % 23];
    }
}
