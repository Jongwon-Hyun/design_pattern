import { SuperBus } from "../product/super-bus";
import { SuperTruck } from "../product/super-truck";
import { Vehicle } from "../product/vehicle";
import { BUS, TRUCK, VehicleType } from "../product/vehicle-type";
import { VehicleFactory } from "./vehicle-factory";

export class SuperVehicleFactory extends VehicleFactory {
    protected createVehicle(vehicleType: VehicleType): Vehicle {
        switch(vehicleType) {
            case BUS: {
                return new SuperBus();
            }
            
            case TRUCK: {
                return new SuperTruck();
            }
        }
    }
}