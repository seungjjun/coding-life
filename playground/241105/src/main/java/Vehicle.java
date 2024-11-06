public class Vehicle {
    private final String color;
    private final int speed;

    public Vehicle(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
            "color='" + color + '\'' +
            ", speed=" + speed +
            '}';
    }
}
