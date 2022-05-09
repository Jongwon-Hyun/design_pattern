import { VehiclePartFactory } from "./part/vehicle_part_factory";
import { Vehicle } from "./vehicle";

export class UltraTruck extends Vehicle {
    static readonly NAME = 'Ultra Truck';

    constructor(private readonly vehiclePartFactory: VehiclePartFactory) {
        super();
        this.name = UltraTruck.NAME;
    }

    assembly() {
        this.engine = this.vehiclePartFactory.createEngine();
        this.tire = this.vehiclePartFactory.createTire();
        this.options = new Array();
    }  
}