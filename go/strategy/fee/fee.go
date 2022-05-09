package fee

const (
	DefaultFee     = 0.03
	PartnershipFee = 0.01
)

type Fee interface {
	Calculate(amount float64) float64
}

type defaultFee struct {
	fee float64
}

func NewDefaultFee() Fee {
	return &defaultFee{fee: DefaultFee}
}

func (d defaultFee) Calculate(amount float64) float64 {
	return amount * d.fee
}

type partnershipFee struct {
	fee float64
}

func NewPartnershipFee() Fee {
	return &partnershipFee{fee: PartnershipFee}
}

func (p partnershipFee) Calculate(amount float64) float64 {
	return amount * p.fee
}
