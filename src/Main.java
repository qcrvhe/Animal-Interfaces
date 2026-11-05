import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class Main {
    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {


        ArrayList<Animal> zoo = new ArrayList<>();
        zoo.add(new Elephant("Ellie", 4000.0, 12));
        zoo.add(new Elephant("Richard", 4300, 12));
        zoo.add(new Eagle("Eddie", 6.7, 210));
        zoo.add(new Gorilla("Hank", 150.0, 12));
        zoo.add(new Gorilla("Amanda", 135.0, 12));
        zoo.add(new Tortoise("Tommy", 30.0, "hexagonal"));

        ArrayList<Escape> animalsWhoEscape = new ArrayList<>();
        ArrayList<Swimmable> animalsWhoSwim = new ArrayList<>();

        for (Animal c : zoo) {
            System.out.println((c.eat()));
            System.out.println((c.responseToDanger()));
            System.out.println((c.makeSound()));

            if (c instanceof Escape) {
                animalsWhoEscape.add((Escape) c);
            }
            if (c instanceof Swimmable) {
                animalsWhoSwim.add((Swimmable) c);
            }
        }
        for (Escape e : animalsWhoEscape) {
            System.out.println(e.escapeEnclosure());
        }

        for (Swimmable s : animalsWhoSwim) {
            System.out.println(s.swim());
        }
        System.out.println(System.getProperty("user.dir")); // prints where "here" is


        FileWriter writer = new FileWriter("save.txt");
        for (Animal c : zoo) {
            writer.write(c.toCsv() + "\n"); // one object per line
        }
        writer.close(); // CRITICAL — flushes and releases the file
zoo.clear();
loadZoo(zoo);
for(Animal c : zoo) {
System.out.println(c);
}
    }


    public static void loadZoo(ArrayList<Animal> zoo) throws IOException {
        Scanner fileScanner = new Scanner(new File("save.txt"));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(",");
            String type = parts[0];
            String name = parts[1];
            double weight = Double.parseDouble(parts[2]);

            switch (type) {
                case "Elephant" -> {
                    int herdSize = Integer.parseInt(parts[3]);
                    zoo.add(new Elephant(name, weight, herdSize));
                }
                case "Eagle" -> {
                    int wingspanCm = Integer.parseInt(parts[3]);
                    zoo.add(new Eagle(name, weight, wingspanCm));
                }
                case "Tortoise" -> {
                    String shellPattern = (parts[3]);
                    zoo.add(new Tortoise(name, weight, shellPattern));
                }
                case "Gorilla" -> {
                    int troopSize = Integer.parseInt(parts[3]);
                    zoo.add(new Gorilla(name, weight, troopSize));
                }
            }

        }
        fileScanner.close();

    }



}