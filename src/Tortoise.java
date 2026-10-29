public class Tortoise extends Reptile implements Swimmable {
    private String shellPattern;

    public Tortoise(String name, double weightKg, String shellPattern) {
        super(name, weightKg);
        this.shellPattern = shellPattern;
    }

    @Override
    public String makeSound() {
        return getName() + " grunts softly.";
    }

    @Override
    public String eat() {
        return getName() + " nibbles leaves and fruit.";
    }

    @Override
    public String responseToDanger() {
        return getName() + " retracts back into its shell.";
    }

    @Override
    public String swim() {
        return getName() + " paddles around the water.";
    }
}