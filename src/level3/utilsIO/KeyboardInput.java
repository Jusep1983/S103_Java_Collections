package level3.utilsIO;

import level3.exceptions.EmptyInputException;
import level3.exceptions.IncorrectNameException;
import level3.exceptions.ExceptionValueOutOfRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KeyboardInput {
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

    public static String readFormatDNI(String message) {
        String dniStr = "", numbers;
        char letter, correctChar;
        int dniNumber;
        boolean correct = false;
        ArrayList<Character> lettersDni = new ArrayList<>(Arrays.asList('T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P',
                'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'));
        do {
            System.out.print(message);
            try {
                dniStr = SC.nextLine().toUpperCase().trim().replaceAll("[^A-Z0-9]", "");
                // Validate length and basic format
                if (dniStr.length() == 9) {
                    numbers = dniStr.substring(0, 8);
                    letter = dniStr.charAt(8);
                    // Verify that the first 8 positions are numbers
                    if (numbers.chars().allMatch(Character::isDigit)) {
                        // Calculate the expected letter
                        dniNumber = Integer.parseInt(numbers);
                        correctChar = lettersDni.get(dniNumber % 23);
                        // Compare the entered letter with the calculated one
                        if (correctChar == letter) {
                            correct = true;
                        } else {
                            System.out.println("La letra del DNI introducido es incorrecta.");
                        }
                    } else {
                        System.out.println("Las primeras 8 posiciones del DNI deben ser números.");
                    }
                } else {
                    System.out.println("Un DNI debe tener 9 caracteres: 8 números y 1 letra.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Error en el formato del DNI. Asegúrate de que sea válido.");
            }
        } while (!correct);
        return dniStr;
    }
}
