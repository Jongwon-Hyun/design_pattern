package abstract_factory.creator;

import abstract_factory.product.SuperBus;
import abstract_factory.product.SuperTruck;
import abstract_factory.product.Vehicle;
import abstract_factory.product.VehicleType;
import abstract_factory.product.part.CityVehiclePartFactory;
import abstract_factory.product.part.OffloadVehiclePartFactory;

public class SuperVehicleFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle(VehicleType vehicleType) {
        return switch (vehicleType) {
            case BUS -> new SuperBus(new CityVehiclePartFactory());
            case TRUCK -> new SuperTruck(new OffloadVehiclePartFactory());
        };
    }
}
