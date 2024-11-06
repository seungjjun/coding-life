public class Car extends Vehicle{

    private final int numberOfWheel;

    public Car(String color, int speed, int numberOfWheel) {
        super(color, speed);
        this.numberOfWheel = numberOfWheel;
    }

    public int getNumberOfWheel() {
        return numberOfWheel;
    }

    @Override
    public String toString() {
        return "Car [color=" + getColor() + ", speed=" + getSpeed() + ", numberOfWheel=" + numberOfWheel + "]";
    }
}
