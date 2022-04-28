package abstract_factory.product;

import abstract_factory.product.part.VehiclePartFactory;

import java.util.List;

public class SuperTruck extends Vehicle {
    public static final String NAME = "Super Truck";
    private final VehiclePartFactory vehiclePartFactory;

    public SuperTruck(VehiclePartFactory vehiclePartFactory) {
        name = NAME;
        this.vehiclePartFactory = vehiclePartFactory;
    }

    @Override
    public void assembly() {
        engine = vehiclePartFactory.createEngine();
        tire = vehiclePartFactory.createTire();
        options = List.of();
    }
}
