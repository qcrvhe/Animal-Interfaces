import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


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
                animalsWhoEscape.add((Escape)c);
            }
            if (c instanceof Swimmable) {
                animalsWhoSwim.add((Swimmable)c);
            }
        }
        for (Escape e : animalsWhoEscape) {
             System.out.println(e.escapeEnclosure());
         }

        for (Swimmable s : animalsWhoSwim) {
            System.out.println(s.swim());
        }

    }
}