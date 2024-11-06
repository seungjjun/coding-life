public class CarBuilder extends VehicleBuilder<CarBuilder> {

    private int numberOfWheel;

    public CarBuilder numberOfWheel(int numberOfWheel) {
        this.numberOfWheel = numberOfWheel;
        return this;
    }

    @Override
    protected CarBuilder self() {
        return this;
    }

    @Override
    public Car build() {
        return new Car(color, speed, numberOfWheel);
    }
}
