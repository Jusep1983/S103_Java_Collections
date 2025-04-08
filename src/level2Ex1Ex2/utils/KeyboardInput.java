package level2Ex1Ex2.utils;

import level2Ex1Ex2.exceptions.EmptyInputException;
import level2Ex1Ex2.exceptions.ValueOutOfRangeException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class KeyboardInput {

    private static final Scanner SC = new Scanner(System.in);

    public static void numberNotEmpty(String input) throws EmptyInputException {
        if (input.isEmpty()) {
            throw new EmptyInputException("el campo no puede estar vacío");
        }
    }

    public static String readInput() {
        return SC.nextLine().trim();
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
                String input = readInput();
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

    public static String checkString() throws EmptyInputException {
        String inputStr = readInput();
        if (inputStr.isEmpty()) {
            throw new EmptyInputException("el nombre no puede estar vacío");
        } else {
            return inputStr;
        }
    }

    public static String readString(String message) {
        while (true) {
            try {
                System.out.print(message);
                return checkString();
            } catch (EmptyInputException | NoSuchElementException | IllegalStateException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

}
