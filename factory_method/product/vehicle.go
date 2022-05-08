package product

import (
	"design_pattern/factory_method/product/part"
	"fmt"
)

type Vehicle interface {
	Assembly()
	LoadShip()
	GetEngine() part.Engine
	GetTire() part.Tire
	GetName() string
}

type vehicle struct {
	name   string
	engine part.Engine
	tire   part.Tire
	Vehicle
}

func (v vehicle) Assembly() {
	fmt.Println(v.engine.String() + " 엔진을 장착")
	fmt.Println(v.tire.String() + " 타이어를 장착")
}

func (v vehicle) LoadShip() {
	fmt.Println("베에 선적")
}

func (v vehicle) GetEngine() part.Engine {
	return v.engine
}

func (v vehicle) GetTire() part.Tire {
	return v.tire
}

func (v vehicle) GetName() string {
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
}

func NewSuperBus() Vehicle {
	superBus := &superBus{
		vehicle: &vehicle{name: SuperBusName, engine: part.EngineHybrid, tire: part.TireNormal},
	}
	superBus.Vehicle = superBus
	return superBus
}

type superTruck struct {
	*vehicle
}

func NewSuperTruck() Vehicle {
	superTruck := &superTruck{
		vehicle: &vehicle{name: SuperTruckName, engine: part.EngineGasoline, tire: part.TireOffload},
	}
	superTruck.Vehicle = superTruck
	return superTruck
}

type ultraBus struct {
	*vehicle
}

func NewUltraBus() Vehicle {
	ultraBus := &ultraBus{
		vehicle: &vehicle{name: UltraBusName, engine: part.EngineGasoline, tire: part.TireNormal},
	}
	ultraBus.Vehicle = ultraBus
	return ultraBus
}

type ultraTruck struct {
	*vehicle
}

func NewUltraTruck() Vehicle {
	ultraTruck := &ultraTruck{
		vehicle: &vehicle{name: UltraTruckName, engine: part.EngineHybrid, tire: part.TireOffload},
	}
	ultraTruck.Vehicle = ultraTruck
	return ultraTruck
}
