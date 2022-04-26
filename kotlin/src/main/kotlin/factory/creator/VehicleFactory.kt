package factory.creator

import factory.product.Vehicle
import factory.product.VehicleType

abstract class VehicleFactory {

    fun orderVehicle(vehicleType: VehicleType): Vehicle {
        val vehicle = createVehicle(vehicleType)

        vehicle.assembly()
        vehicle.loadShip()

        return vehicle
    }

    protected abstract fun createVehicle(vehicleType: VehicleType): Vehicle
}