package factory.creator;

import factory.product.SuperBus;
import factory.product.SuperTruck;
import factory.product.Vehicle;
import factory.product.VehicleType;

public class SuperVehicleFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle(VehicleType vehicleType) {
        return switch (vehicleType) {
            case BUS -> new SuperBus();
            case TRUCK -> new SuperTruck();
        };
    }
}
