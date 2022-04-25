package factory_method.creator;

import factory_method.product.UltraBus;
import factory_method.product.UltraTruck;
import factory_method.product.Vehicle;
import factory_method.product.VehicleType;

public class UltraVehicleFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle(VehicleType vehicleType) {
        return switch (vehicleType) {
            case BUS -> new UltraBus();
            case TRUCK -> new UltraTruck();
        };
    }
}