package abstract_factory.product;

import abstract_factory.product.part.VehiclePartFactory;

public class UltraBus extends Vehicle {
    public static final String NAME = "Ultra Bus";
    private final VehiclePartFactory vehiclePartFactory;

    public UltraBus(VehiclePartFactory vehiclePartFactory) {
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