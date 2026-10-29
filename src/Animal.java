public abstract class Animal {
    private String name;
    private double weightKg;

    public Animal(String name, double weightKg) {
        this.name = name;
        this.weightKg = weightKg;
    }

    public abstract String makeSound();
    public abstract String eat();
    public abstract String responseToDanger();


    public String getName() { return name; }
    public double getWeightKg() { return weightKg; }


    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name
                + " (" + weightKg + " kg)";
    }
}