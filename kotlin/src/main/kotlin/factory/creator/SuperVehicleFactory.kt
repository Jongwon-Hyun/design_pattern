package factory.creator

import factory.product.SuperBus
import factory.product.SuperTruck
import factory.product.Vehicle
import factory.product.VehicleType

class SuperVehicleFactory : VehicleFactory() {
    override fun createVehicle(vehicleType: VehicleType): Vehicle {
        return when (vehicleType) {
            VehicleType.BUS -> SuperBus()
            VehicleType.TRUCK -> SuperTruck()
        }
    }
}