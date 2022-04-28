package product

import (
	"design_pattern/abstract_factory/product/part"
	"fmt"
)

type Vehicle interface {
	Assembly()
	LoadShip()
	GetEngine() part.Engine
	GetTire() part.Tire
	GetOptions() []part.Option
	GetName() string
}

type vehicle struct {
	name    string
	engine  part.Engine
	tire    part.Tire
	options []part.Option
	Vehicle
}

func (v *vehicle) LoadShip() {
	fmt.Println("베에 선적")
}

func (v *vehicle) GetEngine() part.Engine {
	return v.engine
}

func (v *vehicle) GetTire() part.Tire {
	return v.tire
}

func (v *vehicle) GetOptions() []part.Option {
	return v.options
}

func (v *vehicle) GetName() string {
	return v.name
}

const (
	SuperBusName   = "Super Bus"
	SuperTruckName = "Super Truck"
	UltraBusName   = "Ultra Bus"
	UltraTruckName = "Ultra Truck"
)

type superBus struct {
	*vehicle
	vehiclePartFactory part.VehiclePartFactory
}

func NewSuperBus(vehiclePartFactory part.VehiclePartFactory) Vehicle {
	superBus := &superBus{
		vehicle:            &vehicle{name: SuperBusName},
		vehiclePartFactory: vehiclePartFactory,
	}
	superBus.Vehicle = superBus
	return superBus
}

func (s *superBus) Assembly() {
	s.engine = s.vehiclePartFactory.CreateEngine()
	s.tire = s.vehiclePartFactory.CreateTire()
	s.options = s.vehiclePartFactory.CreateOptions()
}

type superTruck struct {
	*vehicle
	vehiclePartFactory part.VehiclePartFactory
}

func NewSuperTruck(vehiclePartFactory part.VehiclePartFactory) Vehicle {
	superTruck := &superTruck{
		vehicle:            &vehicle{name: SuperTruckName},
		vehiclePartFactory: vehiclePartFactory,
	}
	superTruck.Vehicle = superTruck
	return superTruck
}

func (s *superTruck) Assembly() {
	s.engine = s.vehiclePartFactory.CreateEngine()
	s.tire = s.vehiclePartFactory.CreateTire()
	s.options = []part.Option{}
}

type ultraBus struct {
	*vehicle
	vehiclePartFactory part.VehiclePartFactory
}

func NewUltraBus(vehiclePartFactory part.VehiclePartFactory) Vehicle {
	ultraBus := &ultraBus{
		vehicle:            &vehicle{name: UltraBusName},
		vehiclePartFactory: vehiclePartFactory,
	}
	ultraBus.Vehicle = ultraBus
	return ultraBus
}

func (u *ultraBus) Assembly() {
	u.engine = u.vehiclePartFactory.CreateEngine()
	u.tire = u.vehiclePartFactory.CreateTire()
	u.options = u.vehiclePartFactory.CreateOptions()
}

type ultraTruck struct {
	*vehicle
	vehiclePartFactory part.VehiclePartFactory
}

func NewUltraTruck(vehiclePartFactory part.VehiclePartFactory) Vehicle {
	ultraTruck := &ultraTruck{
		vehicle:            &vehicle{name: UltraTruckName},
		vehiclePartFactory: vehiclePartFactory,
	}
	ultraTruck.Vehicle = ultraTruck
	return ultraTruck
}

func (u *ultraTruck) Assembly() {
	u.engine = u.vehiclePartFactory.CreateEngine()
	u.tire = u.vehiclePartFactory.CreateTire()
	u.options = []part.Option{}
}
