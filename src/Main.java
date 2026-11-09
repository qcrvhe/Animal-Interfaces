import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Animal> zoo = new ArrayList<>();

        // Run the three tests
        testGoodLine();
        testTooFewFields();
        testNonNumber();

        System.out.println();

        // Load animals from save.txt
        loadZoo(zoo);

        // Print the animals that loaded successfully
        for (Animal c : zoo) {
            System.out.println(c);
        }
    }

    // Loads animals from the save file
    public static void loadZoo(ArrayList<Animal> zoo) throws IOException {

        Scanner fileScanner = new Scanner(new File("save.txt"));

        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();

            Animal animal = parseLine(line);

            if (animal == null) {
                if (line.isBlank()) {
                    System.out.println("Skipping empty line");
                } else {
                    System.out.println("Skipping bad or malformed line: " + line);
                }
            } else {
                zoo.add(animal);
            }
        }

        fileScanner.close();
    }

    // Converts one line of text into an Animal object
    public static Animal parseLine(String line) {

        String[] parts = line.split(",");

        if (parts.length != 4) {
            return null;
        }

        try {

            String type = parts[0];
            String name = parts[1];
            double weight = Double.parseDouble(parts[2]);

            switch (type) {

                case "Elephant" -> {
                    int herdSize = Integer.parseInt(parts[3]);
                    return new Elephant(name, weight, herdSize);
                }

                case "Eagle" -> {
                    int wingspanCm = Integer.parseInt(parts[3]);
                    return new Eagle(name, weight, wingspanCm);
                }

                case "Tortoise" -> {
                    String shellPattern = parts[3];
                    return new Tortoise(name, weight, shellPattern);
                }

                case "Gorilla" -> {
                    int troopSize = Integer.parseInt(parts[3]);
                    return new Gorilla(name, weight, troopSize);
                }

                default -> {
                    return null;
                }
            }

        } catch (NumberFormatException e) {
            return null;
        }
    }

    // checks if a valid line loads correctly
    public static void testGoodLine() {

        Animal animal = parseLine("Elephant,Lucy,4000.0,10");

        if (animal != null && animal.getName().equals("Lucy")) {
            System.out.println("Good line test: PASS");
        } else {
            System.out.println("Good line test: FAIL");
        }
    }

    // checks if a line with too few fields is rejected
    public static void testTooFewFields() {

        Animal animal = parseLine("Eagle,Sam,5.5");

        if (animal == null) {
            System.out.println("Too few fields test: PASS");
        } else {
            System.out.println("Too few fields test: FAIL");
        }
    }

    // checks if a non-number is rejected
    public static void testNonNumber() {

        Animal animal = parseLine("Elephant,Lucy,heavy,10");

        if (animal == null) {
            System.out.println("Non-number test: PASS");
        } else {
            System.out.println("Non-number test: FAIL");
        }
    }
}