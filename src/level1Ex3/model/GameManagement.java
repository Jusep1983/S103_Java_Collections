package level1Ex3.model;

import level1Ex3.utils.KeyboardInput;

import java.io.*;
import java.util.*;

public class GameManagement {
    private String filePath;
    private Map<String, String> countriesMap;
    private String player;
    private int score;

    public GameManagement() {
        this.filePath = "src" + File.separator + "level1Ex3" + File.separator + "files";
        this.countriesMap = new HashMap<>();
        this.score = 0;
        this.player = "";
    }

    public boolean fileExists() {
        File file = new File(this.filePath + File.separator + "countries.txt");
        return file.exists();
    }

    public void loadData() {
        String fullPath = this.filePath + File.separator + "countries.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fullPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(" ", 2);
                    if (parts.length == 2) {
                        String key = parts[0].trim();
                        String value = parts[1].trim();
                        this.countriesMap.put(key, value);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public void game() {
        String randomCountry;
        int attempt = 0;
        this.player = askPlayer();
        do {
            randomCountry = showRandomCountry();
            this.score = +gameTurn("Enter the capital of ", randomCountry);
            attempt++;
        } while (attempt < 10);
        writeClassification();
    }


    public String askPlayer() {
        this.player = KeyboardInput.readString("Enter the player's name: ");
        return this.player;
    }

    public String showRandomCountry() {
        List<String> keys = new ArrayList<>(this.countriesMap.keySet());
        String randomCountry;
        Random random = new Random();
        randomCountry = keys.get(random.nextInt(keys.size()));
        return randomCountry;
    }

    public int gameTurn(String message, String randomCountry) {
        String capital = "", capitalClean = "";
        randomCountry = randomCountry.replace("_", " ");
        String randomCountryClean = clearText(randomCountry);
        String userCapital = KeyboardInput.readString(message + randomCountry.replace("_", " ") + ": ");
        userCapital = clearText(userCapital);
        for (Map.Entry<String, String> hashMap : this.countriesMap.entrySet()) {
            String country = clearText(hashMap.getKey());
            if (country.equalsIgnoreCase(randomCountryClean)) {
                capital = hashMap.getValue().replace("_", " ");
                capitalClean = clearText(capital);
            }
        }
        if (userCapital.equalsIgnoreCase(capitalClean)) {
            System.out.println("Congratulations, you got it right! ");
            System.out.println("The capital of  " + randomCountry.replace("_", " ") + " is " + capital.replace("_", " ") + ". You have earned 1 point.");
            this.score++;
        } else {
            System.out.println("The capital of  " + randomCountry.replace("_", " ") + " is " + capital.replace("_", " ") + ".");
            System.out.println("Sorry, try again...");
        }
        System.out.println("Total score: " + this.score);
        return score;
    }

    public String clearText(String text) {
        String cleanText;
        cleanText = text.replace("_", " ");
        return cleanText;
    }

    public void writeClassification() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.filePath + File.separator + "classification.txt", true))) {
            String data = "Player " + this.player + " " + this.score + " points";  // Build the line to save
            bw.write(data);
            bw.newLine();
            System.out.println("Data saved in the file classification.txt: " + data);
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
