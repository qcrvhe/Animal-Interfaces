public class Eagle extends Bird {
    private int wingspanCm;

    public Eagle(String name, double weightKg, int wingspanCm) {
        super(name, weightKg);
        this.wingspanCm = wingspanCm;
    }

    @Override
    public String makeSound() {
        return getName() + " screeches!";
    }

    @Override
    public String eat() {
        return getName() + " tears into the fish.";
    }

    @Override
    public String responseToDanger() {
        return getName() + " swoops down with maximum force.";
    }
}