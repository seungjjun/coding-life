public abstract class VehicleBuilder<T extends VehicleBuilder<T>> {

    protected String color;
    protected int speed;

    public T color(String color) {
        this.color = color;
        return self();
    }

    public T speed(int speed) {
        this.speed = speed;
        return self();
    }

    // 서브클래스에서 자신의 인스턴스를 반환하도록 추상 메서드 정의
    protected abstract T self();

    // 최종적으로 Vehicle 객체를 생성하는 빌드 메서드
    public Vehicle build() {
        return new Vehicle(color, speed);
    }
}
