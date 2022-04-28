import { Engine, HYBRID_ENGINE } from "./engine";
import { CRUISE_CONTROL_OPTION, NAVIGATION_OPTION, Option } from "./option";
import { NORMAL_TIRE, Tire } from "./tire";
import { VehiclePartFactory } from "./vehicle_part_factory";

export class CityVehicleFactory implements VehiclePartFactory {
    createEngine(): Engine {
        return HYBRID_ENGINE;
    }

    createTire(): Tire {
        return NORMAL_TIRE;
    }

    createOptions(): Option[] {
        return new Array(NAVIGATION_OPTION, CRUISE_CONTROL_OPTION);
    }
}