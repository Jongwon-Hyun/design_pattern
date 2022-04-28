import { VehiclePartFactory } from "./part/vehicle_part_factory";
import { Vehicle } from "./vehicle";

export class UltraBus extends Vehicle {
    static readonly NAME = 'Ultra Bus';

    constructor(private readonly vehiclePartFactory: VehiclePartFactory) {
        super();
        this.name = UltraBus.NAME;
    }

    public assembly() {
        this.engine = this.vehiclePartFactory.createEngine();
        this.tire = this.vehiclePartFactory.createTire();
        this.options = this.vehiclePartFactory.createOptions();
    }
}