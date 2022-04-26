package factory_method.creator

import factory_method.product.SuperBus
import factory_method.product.SuperTruck
import factory_method.product.Vehicle
import factory_method.product.VehicleType

class SuperVehicleFactory : VehicleFactory() {
    override fun createVehicle(vehicleType: VehicleType): Vehicle {
        return when (vehicleType) {
            VehicleType.BUS -> SuperBus()
            VehicleType.TRUCK -> SuperTruck()
        }
    }
}