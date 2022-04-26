package factory_method.creator

import factory_method.product.Vehicle
import factory_method.product.VehicleType

abstract class VehicleFactory {

    fun orderVehicle(vehicleType: VehicleType): Vehicle {
        val vehicle = createVehicle(vehicleType)

        vehicle.assembly()
        vehicle.loadShip()

        return vehicle
    }

    protected abstract fun createVehicle(vehicleType: VehicleType): Vehicle
}