import { GASOLINE_ENGINE, HYBRID_ENGINE } from "./part/engine";
import { NORMAL_TIRE } from "./part/tire";
import { Vehicle } from "./vehicle";

export class UltraBus extends Vehicle {
    static readonly NAME = 'Ultra Bus';

    constructor() {
        super();
        this.name = UltraBus.NAME;
        this.engine = GASOLINE_ENGINE;
        this.tire = NORMAL_TIRE;
    }
}