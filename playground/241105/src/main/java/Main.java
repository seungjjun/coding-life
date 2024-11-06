public class Main {

    public static void main(String[] args) {
        Car car = new CarBuilder()
            .color("Red")
            .speed(180)
            .numberOfWheel(4)
            .build();

        System.out.println(car.toString());

        Vehicle bike = new BikeBuilder()
            .color("black")
            .speed(150)
            .hasHelmet(true)
            .build();

        System.out.println(bike.toString());
    }
}
