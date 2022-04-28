package abstract_factory.creator

import abstract_factory.product.SuperBus
import abstract_factory.product.SuperTruck
import abstract_factory.product.Vehicle
import abstract_factory.product.VehicleType
import abstract_factory.product.part.CityVehiclePartFactory
import abstract_factory.product.part.OffloadVehiclePartFactory

class SuperVehicleFactory : VehicleFactory() {
    override fun createVehicle(vehicleType: VehicleType): Vehicle {
        return when (vehicleType) {
            VehicleType.BUS -> SuperBus(CityVehiclePartFactory())
            VehicleType.TRUCK -> SuperTruck(OffloadVehiclePartFactory())
        }
    }
}