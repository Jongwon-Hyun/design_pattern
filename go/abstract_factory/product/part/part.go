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

type Option struct {
	slug string
}

var (
	OptionNavigation    = Option{"navigation"}
	OptionAudioSystem   = Option{"audio_system"}
	OptionCruiseControl = Option{"cruise_control"}
)

func (o Option) String() string {
	return o.slug
}
