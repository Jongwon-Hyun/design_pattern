package part

type Engine struct {
	slug string
}

var (
	EngineGasoline = Engine{"gasoline"}
	EngineHybrid   = Engine{"hybrid"}
)

func (e Engine) String() string {
	return e.slug
}

type Tire struct {
	slug string
}

var (
	TireNormal  = Tire{"normal"}
	TireOffload = Tire{"offload"}
)

func (t Tire) String() string {
	return t.slug
}
