package factory.creator

import factory.product.UltraBus
import factory.product.UltraTruck
import factory.product.Vehicle
import factory.product.VehicleType

class UltraVehicleFactory : VehicleFactory() {
    override fun createVehicle(vehicleType: VehicleType): Vehicle {
        return when (vehicleType) {
            VehicleType.BUS -> UltraBus()
            VehicleType.TRUCK -> UltraTruck()
        }
    }
}