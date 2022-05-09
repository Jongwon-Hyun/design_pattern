const vehicleType = {
    bus: 'bus',
    truck: 'truck',
} as const

type VehicleType = typeof vehicleType[keyof typeof vehicleType];
const BUS = vehicleType.bus;
const TRUCK = vehicleType.truck;

export {
    VehicleType, BUS, TRUCK
}