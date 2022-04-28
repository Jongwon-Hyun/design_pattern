import { SuperVehicleFactory } from "./creator/super-vehicle-factory";
import { UltraVehicleFactory } from "./creator/ultra-vehicle-factory";
import { GASOLINE_ENGINE, HYBRID_ENGINE } from "./product/part/engine";
import { AUDIO_SYSTEM_OPTION, CRUISE_CONTROL_OPTION, NAVIGATION_OPTION } from "./product/part/option";
import { NORMAL_TIRE, OFFLOAD_TIRE } from "./product/part/tire";
import { SuperBus } from "./product/super-bus";
import { SuperTruck } from "./product/super-truck";
import { UltraBus } from "./product/ultra-bus";
import { UltraTruck } from "./product/ultra-truck";
import { BUS, TRUCK } from "./product/vehicle-type";

test('Abstract Factory Run', () => {
    const superVehicleFactory = new SuperVehicleFactory();
    const ultraVehicleFactory = new UltraVehicleFactory();

    const superBus = superVehicleFactory.orderVehicle(BUS);
    expect(superBus.getName()).toEqual(SuperBus.NAME);
    expect(superBus.getEngine()).toEqual(HYBRID_ENGINE);
    expect(superBus.getTire()).toEqual(NORMAL_TIRE);
    expect(superBus.getOptions()).toEqual(expect.arrayContaining(new Array(NAVIGATION_OPTION, CRUISE_CONTROL_OPTION)));

    const superTruck = superVehicleFactory.orderVehicle(TRUCK);
    expect(superTruck.getName()).toEqual(SuperTruck.NAME);
    expect(superTruck.getEngine()).toEqual(GASOLINE_ENGINE);
    expect(superTruck.getTire()).toEqual(OFFLOAD_TIRE);
    expect(superTruck.getOptions()).toEqual(new Array());

    const ultraBus = ultraVehicleFactory.orderVehicle(BUS);
    expect(ultraBus.getName()).toEqual(UltraBus.NAME);
    expect(ultraBus.getEngine()).toEqual(GASOLINE_ENGINE);
    expect(ultraBus.getTire()).toEqual(OFFLOAD_TIRE);
    expect(ultraBus.getOptions()).toEqual(expect.arrayContaining(new Array(NAVIGATION_OPTION, AUDIO_SYSTEM_OPTION)));

    const ultraTruck = ultraVehicleFactory.orderVehicle(TRUCK);
    expect(ultraTruck.getName()).toEqual(UltraTruck.NAME);
    expect(ultraTruck.getEngine()).toEqual(HYBRID_ENGINE);
    expect(ultraTruck.getTire()).toEqual(NORMAL_TIRE);
    expect(ultraTruck.getOptions()).toEqual(new Array());
});