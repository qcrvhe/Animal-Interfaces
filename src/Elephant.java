public class Elephant extends Mammal implements Escape {
    private int herdSize;

    public Elephant(String name, double weightKg, int herdSize) {
        super(name, weightKg);
        this.herdSize = herdSize;
    }

    @Override
    public String makeSound() {
        return getName() + " trumpets!";
    }

    @Override
    public String eat() {
        return getName() + " munches grass and bark.";
    }

    @Override
    public String responseToDanger() {
        return getName() + " gathers in a tight ring with its herd.";
    }

    @Override
    public String escapeEnclosure() {
        return getName() + " charges into the fence and rumbles out!";
    }


}