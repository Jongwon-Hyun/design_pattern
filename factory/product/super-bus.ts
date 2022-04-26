import { HYBRID_ENGINE } from "./part/engine";
import { NORMAL_TIRE } from "./part/tire";
import { Vehicle } from "./vehicle";

export class SuperBus extends Vehicle {
    static readonly NAME = 'Super Bus';

    constructor() {
        super();
        this.name = SuperBus.NAME;
        this.engine = HYBRID_ENGINE;
        this.tire = NORMAL_TIRE;
    }
}