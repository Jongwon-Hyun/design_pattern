package factory.creator;

import factory.product.Vehicle;
import factory.product.VehicleType;

public abstract class VehicleFactory {
    public Vehicle orderVehicle(VehicleType vehicleType) {
        var vehicle = createVehicle(vehicleType);

        vehicle.assembly();
        vehicle.loadShip();

        return vehicle;
    }

    protected abstract Vehicle createVehicle(VehicleType vehicleType);
}
