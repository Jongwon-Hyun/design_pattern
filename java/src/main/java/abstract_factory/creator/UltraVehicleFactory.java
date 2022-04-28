package abstract_factory.creator;

import abstract_factory.product.UltraBus;
import abstract_factory.product.UltraTruck;
import abstract_factory.product.Vehicle;
import abstract_factory.product.VehicleType;
import abstract_factory.product.part.CityVehiclePartFactory;
import abstract_factory.product.part.OffloadVehiclePartFactory;

public class UltraVehicleFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle(VehicleType vehicleType) {
        return switch (vehicleType) {
            case BUS -> new UltraBus(new OffloadVehiclePartFactory());
            case TRUCK -> new UltraTruck(new CityVehiclePartFactory());
        };
    }
}