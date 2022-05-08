package creator

import (
	"design_pattern/factory_method/product"
	"errors"
)

type VehicleFactory interface {
	OrderVehicle(vehicleType product.VehicleType) (product.Vehicle, error)
	createVehicle(vehicleType product.VehicleType) (product.Vehicle, error)
}

type vehicleFactory struct {
	VehicleFactory
}

func (v vehicleFactory) OrderVehicle(vehicleType product.VehicleType) (product.Vehicle, error) {
	vehicle, err := v.VehicleFactory.createVehicle(vehicleType)
	if err != nil {
		return nil, err
	}

	vehicle.Assembly()
	vehicle.LoadShip()

	return vehicle, nil
}

type superVehicleFactory struct {
	*vehicleFactory
}

func NewSuperVehicleFactory() VehicleFactory {
	superVehicleFactory := &superVehicleFactory{&vehicleFactory{}}
	superVehicleFactory.VehicleFactory = superVehicleFactory
	return superVehicleFactory
}

func (s superVehicleFactory) createVehicle(vehicleType product.VehicleType) (product.Vehicle, error) {
	switch vehicleType.String() {
	case product.Bus.String():
		return product.NewSuperBus(), nil
	case product.Truck.String():
		return product.NewSuperTruck(), nil
	default:
		return nil, errors.New("invalid vehicle type")
	}
}

type ultraVehicleFactory struct {
	*vehicleFactory
}

func NewUltraVehicleFactory() VehicleFactory {
	ultraVehicleFactory := &ultraVehicleFactory{&vehicleFactory{}}
	ultraVehicleFactory.VehicleFactory = ultraVehicleFactory
	return ultraVehicleFactory
}

func (u ultraVehicleFactory) createVehicle(vehicleType product.VehicleType) (product.Vehicle, error) {
	switch vehicleType.String() {
	case product.Bus.String():
		return product.NewUltraBus(), nil
	case product.Truck.String():
		return product.NewUltraTruck(), nil
	default:
		return nil, errors.New("invalid vehicle type")
	}
}
