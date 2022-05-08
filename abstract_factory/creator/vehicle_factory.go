package creator

import (
	"design_pattern/abstract_factory/product"
	"design_pattern/abstract_factory/product/part"
	"errors"
)

type VehicleFactory interface {
	OrderVehicle(vehicleType product.VehicleType) (product.Vehicle, error)
	createVehicle(vehicleType product.VehicleType) (product.Vehicle, error)
}

type vehicleFactory struct {
	VehicleFactory
}

func (v *vehicleFactory) OrderVehicle(vehicleType product.VehicleType) (product.Vehicle, error) {
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

func (s *superVehicleFactory) createVehicle(vehicleType product.VehicleType) (product.Vehicle, error) {
	switch vehicleType.String() {
	case product.Bus.String():
		return product.NewSuperBus(part.NewCityVehiclePartFactory()), nil
	case product.Truck.String():
		return product.NewSuperTruck(part.NewOffloadVehiclePartFactory()), nil
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

func (u *ultraVehicleFactory) createVehicle(vehicleType product.VehicleType) (product.Vehicle, error) {
	switch vehicleType.String() {
	case product.Bus.String():
		return product.NewUltraBus(part.NewOffloadVehiclePartFactory()), nil
	case product.Truck.String():
		return product.NewUltraTruck(part.NewCityVehiclePartFactory()), nil
	default:
		return nil, errors.New("invalid vehicle type")
	}
}
