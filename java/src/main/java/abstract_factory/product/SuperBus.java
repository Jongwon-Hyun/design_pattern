package abstract_factory.product;

import abstract_factory.product.part.VehiclePartFactory;

public class SuperBus extends Vehicle {
    public static final String NAME = "Super Bus";
    private final VehiclePartFactory vehiclePartFactory;

    public SuperBus(VehiclePartFactory vehiclePartFactory) {
        name = NAME;
        this.vehiclePartFactory = vehiclePartFactory;
    }

    @Override
    public void assembly() {
        engine = vehiclePartFactory.createEngine();
        tire = vehiclePartFactory.createTire();
        options = vehiclePartFactory.createOptions();
    }
}
