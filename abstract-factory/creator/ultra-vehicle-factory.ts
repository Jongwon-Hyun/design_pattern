import { CityVehicleFactory } from "../product/part/city_vehicle_factory";
import { OffloadVehicleFactory } from "../product/part/offload_vehicle_factory";
import { UltraBus } from "../product/ultra-bus";
import { UltraTruck } from "../product/ultra-truck";
import { Vehicle } from "../product/vehicle";
import { BUS, TRUCK, VehicleType } from "../product/vehicle-type";
import { VehicleFactory } from "./vehicle-factory";

export class UltraVehicleFactory extends VehicleFactory {
    protected createVehicle(vehicleType: VehicleType): Vehicle {
        switch(vehicleType) {
            case BUS: return new UltraBus(new OffloadVehicleFactory());
            case TRUCK: return new UltraTruck(new CityVehicleFactory());
        }
    }
}