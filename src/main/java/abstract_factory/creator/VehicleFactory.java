package abstract_factory.creator;

import abstract_factory.product.Vehicle;
import abstract_factory.product.VehicleType;

public abstract class VehicleFactory {
    public Vehicle orderVehicle(VehicleType vehicleType) {
        var vehicle = createVehicle(vehicleType);

        vehicle.assembly();
        vehicle.loadShip();

        return vehicle;
    }

    protected abstract Vehicle createVehicle(VehicleType vehicleType);
}
