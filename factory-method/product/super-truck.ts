import { GASOLINE_ENGINE } from "./part/engine";
import { OFFLOAD_TIRE } from "./part/tire";
import { Vehicle } from "./vehicle";

export class SuperTruck extends Vehicle {
    static readonly NAME = 'Super Truck';

    constructor() {
        super();
        this.name = SuperTruck.NAME;
        this.engine = GASOLINE_ENGINE;
        this.tire = OFFLOAD_TIRE;
    }
}