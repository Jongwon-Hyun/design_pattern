import { GASOLINE_ENGINE, HYBRID_ENGINE } from "./part/engine";
import { OFFLOAD_TIRE } from "./part/tire";
import { Vehicle } from "./vehicle";

export class UltraTruck extends Vehicle {
    static readonly NAME = 'Ultra Truck';

    constructor() {
        super();
        this.name = UltraTruck.NAME;
        this.engine = HYBRID_ENGINE;
        this.tire = OFFLOAD_TIRE;
    }
}