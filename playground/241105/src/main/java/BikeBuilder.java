public class BikeBuilder extends VehicleBuilder<BikeBuilder>{

    private boolean hasHelmet;

    public BikeBuilder hasHelmet(boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
        return this;
    }

    @Override
    protected BikeBuilder self() {
        return this;
    }

    @Override
    public Vehicle build() {
        return new Bike(color, speed, hasHelmet);
    }
}
