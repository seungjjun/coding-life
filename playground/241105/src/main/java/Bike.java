public class Bike extends Vehicle {

    private final boolean hasHelmet;

    public Bike(String color, int speed, boolean hasHelmet) {
        super(color, speed);
        this.hasHelmet = hasHelmet;
    }

    public boolean isHasHelmet() {
        return hasHelmet;
    }

    @Override
    public String toString() {
        return "Bike [color=" + getColor() + ", speed=" + getSpeed() + ", hasHelmet=" + hasHelmet + "]";
    }
}
