package abstract_factory.product;

import abstract_factory.product.part.VehiclePartFactory;

import java.util.List;

public class UltraTruck extends Vehicle {
    public static final String NAME = "Ultra Truck";
    private final VehiclePartFactory vehiclePartFactory;

    public UltraTruck(VehiclePartFactory vehiclePartFactory) {
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
