package abstract_factory.creator

import abstract_factory.product.UltraBus
import abstract_factory.product.UltraTruck
import abstract_factory.product.Vehicle
import abstract_factory.product.VehicleType
import abstract_factory.product.part.CityVehiclePartFactory
import abstract_factory.product.part.OffloadVehiclePartFactory

class UltraVehicleFactory : VehicleFactory() {
    override fun createVehicle(vehicleType: VehicleType): Vehicle {
        return when (vehicleType) {
            VehicleType.BUS -> UltraBus(OffloadVehiclePartFactory())
            VehicleType.TRUCK -> UltraTruck(CityVehiclePartFactory())
        }
    }
}