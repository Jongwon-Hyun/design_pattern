import { VehiclePartFactory } from "./part/vehicle_part_factory";
import { Vehicle } from "./vehicle";

export class SuperTruck extends Vehicle {
    static readonly NAME = 'Super Truck';

    constructor(private readonly vehiclePartFactory: VehiclePartFactory) {
        super();
        this.name = SuperTruck.NAME;
    }

    assembly() {
        this.engine = this.vehiclePartFactory.createEngine();
        this.tire = this.vehiclePartFactory.createTire();
        this.options = new Array();
    }
}