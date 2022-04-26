import { UltraBus } from "../product/ultra-bus";
import { UltraTruck } from "../product/ultra-truck";
import { Vehicle } from "../product/vehicle";
import { BUS, TRUCK, VehicleType } from "../product/vehicle-type";
import { VehicleFactory } from "./vehicle-factory";

export class UltraVehicleFactory extends VehicleFactory {
    protected createVehicle(vehicleType: VehicleType): Vehicle {
        switch(vehicleType) {
            case BUS: {
                return new UltraBus;
            }
            
            case TRUCK: {
                return new UltraTruck;
            }
        }
    }
}