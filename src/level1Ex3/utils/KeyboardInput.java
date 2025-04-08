package level1Ex3.utils;

import level1Ex3.exceptions.EmptyInputException;
import level1Ex3.exceptions.IncorrectNameException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class KeyboardInput {

    private static final Scanner SC = new Scanner(System.in);

    public static String readInput() {
        return SC.nextLine().trim();
    }

    public static String checkString() throws EmptyInputException, IncorrectNameException {
        String inputStr = readInput();
        if (inputStr.isEmpty()) {
            throw new EmptyInputException("the name cannot be empty");
        } else if (inputStr.matches(".*\\d.*")) {
            throw new IncorrectNameException("the name cannot contain numbers");
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

}
