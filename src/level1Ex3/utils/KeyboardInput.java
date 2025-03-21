package level1Ex3.utils;

import level1Ex3.exceptions.EmptyInputException;
import level1Ex3.exceptions.IncorrectNameException;

import java.util.Scanner;

public class KeyboardInput {

    private static final Scanner SC = new Scanner(System.in);

    public static String readString(String message) {
        String inputStr = "";
        boolean correct = false;
        do {
            System.out.print(message);
            try {
                inputStr = SC.nextLine().trim();
                if (inputStr.matches(".*\\d.*")) {
                    throw new IncorrectNameException("the player's name cannot contain numbers.");
                }
                if (inputStr.isEmpty()) {
                    throw new EmptyInputException("the player's name cannot be empty.");
                }
                correct = true;
            } catch (EmptyInputException | IncorrectNameException e) {
                System.out.println("Error, " + e.getMessage());
            }
        } while (!correct);
        return inputStr;
    }
}
