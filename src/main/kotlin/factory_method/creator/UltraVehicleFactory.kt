package factory_method.creator

import factory_method.product.UltraBus
import factory_method.product.UltraTruck
import factory_method.product.Vehicle
import factory_method.product.VehicleType

class UltraVehicleFactory : VehicleFactory() {
    override fun createVehicle(vehicleType: VehicleType): Vehicle {
        return when (vehicleType) {
            VehicleType.BUS -> UltraBus()
            VehicleType.TRUCK -> UltraTruck()
        }
    }
}