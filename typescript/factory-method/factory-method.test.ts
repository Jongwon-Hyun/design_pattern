import { SuperVehicleFactory } from "./creator/super-vehicle-factory";
import { UltraVehicleFactory } from "./creator/ultra-vehicle-factory";
import { GASOLINE_ENGINE, HYBRID_ENGINE } from "./product/part/engine";
import { NORMAL_TIRE, OFFLOAD_TIRE } from "./product/part/tire";
import { SuperBus } from "./product/super-bus";
import { SuperTruck } from "./product/super-truck";
import { UltraBus } from "./product/ultra-bus";
import { UltraTruck } from "./product/ultra-truck";
import { BUS, TRUCK } from "./product/vehicle-type";

test('Test Factory Method', () => {
    const superVehicleFactory = new SuperVehicleFactory();
    const ultraVehicleFactory = new UltraVehicleFactory();

    const superBus = superVehicleFactory.orderVehicle(BUS);
    expect(superBus.getName()).toEqual(SuperBus.NAME);
    expect(superBus.getEngine()).toEqual(HYBRID_ENGINE);
    expect(superBus.getTire()).toEqual(NORMAL_TIRE);

    const superTruck = superVehicleFactory.orderVehicle(TRUCK);
    expect(superTruck.getName()).toEqual(SuperTruck.NAME);
    expect(superTruck.getEngine()).toEqual(GASOLINE_ENGINE);
    expect(superTruck.getTire()).toEqual(OFFLOAD_TIRE);

    const ultraBus = ultraVehicleFactory.orderVehicle(BUS);
    expect(ultraBus.getName()).toEqual(UltraBus.NAME);
    expect(ultraBus.getEngine()).toEqual(GASOLINE_ENGINE);
    expect(ultraBus.getTire()).toEqual(NORMAL_TIRE);

    const ultraTruck = ultraVehicleFactory.orderVehicle(TRUCK);
    expect(ultraTruck.getName()).toEqual(UltraTruck.NAME);
    expect(ultraTruck.getEngine()).toEqual(HYBRID_ENGINE);
    expect(ultraTruck.getTire()).toEqual(OFFLOAD_TIRE);
});