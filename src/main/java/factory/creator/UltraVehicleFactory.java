package factory.creator;

import factory.product.UltraBus;
import factory.product.UltraTruck;
import factory.product.Vehicle;
import factory.product.VehicleType;

public class UltraVehicleFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle(VehicleType vehicleType) {
        return switch(vehicleType) {
            case BUS -> new UltraBus();
            case TRUCK -> new UltraTruck();
        };
    }
}