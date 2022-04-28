package abstract_factory.creator

import abstract_factory.product.Vehicle
import abstract_factory.product.VehicleType

abstract class VehicleFactory {

    fun orderVehicle(vehicleType: VehicleType): Vehicle {
        val vehicle = createVehicle(vehicleType)

        vehicle.assembly()
        vehicle.loadShip()

        return vehicle
    }

    protected abstract fun createVehicle(vehicleType: VehicleType): Vehicle
}