package factory_method.creator;

import factory_method.product.Vehicle;
import factory_method.product.VehicleType;

public abstract class VehicleFactory {
    public Vehicle orderVehicle(VehicleType vehicleType) {
        final var vehicle = createVehicle(vehicleType);

        vehicle.assembly();
        vehicle.loadShip();

        return vehicle;
    }

    protected abstract Vehicle createVehicle(VehicleType vehicleType);
}
