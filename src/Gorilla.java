public class Gorilla extends Mammal implements Escape{

private int troopSize;

    public Gorilla(String name, double weightKg, int troopSize) {
        super(name, weightKg);
        this.troopSize = troopSize;
    }
    @Override
    public String makeSound() {
        return getName() + " hoots and roars!";
    }

    @Override
    public String eat() {
        return getName() + " chows down on celery sticks.";
    }

    @Override
    public String responseToDanger() {
        return getName() + " pounds its chest rapidly.";

    }

    @Override
    public String escapeEnclosure() {
        return getName() + " climbs up a drooping tree branch and hoists itself outside of the enclosure!";
    }
}
