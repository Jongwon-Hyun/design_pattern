package product

type VehicleType struct {
	slug string
}

var (
	Bus   = VehicleType{"bus"}
	Truck = VehicleType{"truck"}
)

func (v VehicleType) String() string {
	return v.slug
}
