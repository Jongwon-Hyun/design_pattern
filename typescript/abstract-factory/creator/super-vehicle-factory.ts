import { CityVehicleFactory } from "../product/part/city_vehicle_factory";
import { OffloadVehicleFactory } from "../product/part/offload_vehicle_factory";
import { SuperBus } from "../product/super-bus";
import { SuperTruck } from "../product/super-truck";
import { Vehicle } from "../product/vehicle";
import { BUS, TRUCK, VehicleType } from "../product/vehicle-type";
import { VehicleFactory } from "./vehicle-factory";

export class SuperVehicleFactory extends VehicleFactory {
    protected createVehicle(vehicleType: VehicleType): Vehicle {
        switch(vehicleType) {
            case BUS: return new SuperBus(new CityVehicleFactory());
            case TRUCK: return new SuperTruck(new OffloadVehicleFactory());
            
        }
    }
}