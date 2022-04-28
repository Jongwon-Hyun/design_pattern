import { Engine, GASOLINE_ENGINE } from "./engine";
import { AUDIO_SYSTEM_OPTION, NAVIGATION_OPTION, Option } from "./option";
import { OFFLOAD_TIRE, Tire } from "./tire";
import { VehiclePartFactory } from "./vehicle_part_factory";

export class OffloadVehicleFactory implements VehiclePartFactory {
    createEngine(): Engine {
        return GASOLINE_ENGINE;
    }

    createTire(): Tire {
        return OFFLOAD_TIRE;
    }

    createOptions(): Option[] {
        return new Array(NAVIGATION_OPTION, AUDIO_SYSTEM_OPTION);
    }
}