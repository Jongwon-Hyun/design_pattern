package part

type VehiclePartFactory interface {
	CreateEngine() Engine
	CreateTire() Tire
	CreateOptions() []Option
}

type cityVehiclePartFactory struct{}

func NewCityVehiclePartFactory() VehiclePartFactory {
	return &cityVehiclePartFactory{}
}

func (c *cityVehiclePartFactory) CreateEngine() Engine {
	return EngineHybrid
}

func (c *cityVehiclePartFactory) CreateTire() Tire {
	return TireNormal
}

func (c *cityVehiclePartFactory) CreateOptions() []Option {
	return []Option{OptionNavigation, OptionCruiseControl}
}

type offloadVehiclePartFactory struct{}

func NewOffloadVehiclePartFactory() VehiclePartFactory {
	return &offloadVehiclePartFactory{}
}

func (o *offloadVehiclePartFactory) CreateEngine() Engine {
	return EngineGasoline
}

func (o *offloadVehiclePartFactory) CreateTire() Tire {
	return TireOffload
}

func (o *offloadVehiclePartFactory) CreateOptions() []Option {
	return []Option{OptionNavigation, OptionAudioSystem}
}
