import { Vehicle } from "../product/vehicle";
import { VehicleType } from "../product/vehicle-type";

export abstract class VehicleFactory {
    orderVehicle(vehicleType: VehicleType): Vehicle {
        const vehicle = this.createVehicle(vehicleType);

        vehicle.assembly();
        vehicle.loadShip();

        return vehicle;
    }

    protected abstract createVehicle(vehicleType: VehicleType): Vehicle;
}