package factory_method.creator;

import factory_method.product.SuperBus;
import factory_method.product.SuperTruck;
import factory_method.product.Vehicle;
import factory_method.product.VehicleType;

public class SuperVehicleFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle(VehicleType vehicleType) {
        return switch (vehicleType) {
            case BUS -> new SuperBus();
            case TRUCK -> new SuperTruck();
        };
    }
}
