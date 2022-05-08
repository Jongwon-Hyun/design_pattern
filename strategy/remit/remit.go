package remit

import "design_pattern/strategy/fee"

type remit struct {
	fee                   fee.Fee
	createTransferMessage func() string
}

func (r remit) CalculateAmount(amount float64) float64 {
	return amount + r.calculateFee(amount)
}

func (r remit) calculateFee(amount float64) float64 {
	return r.fee.Calculate(amount)
}

type abcBankRemit struct {
	*remit
}

func NewAbcBankRemit(fee fee.Fee) *abcBankRemit {
	remit := &remit{
		fee: fee,
		createTransferMessage: func() string {
			return "Hey Abc Bank! I will give you money! OK?"
		},
	}
	return &abcBankRemit{remit: remit}
}

type defBankRemit struct {
	*remit
}

func NewDefBankRemit(fee fee.Fee) *defBankRemit {
	remit := &remit{
		fee: fee,
		createTransferMessage: func() string {
			return "Def Bank! I will send the money! give me result!"
		},
	}
	return &defBankRemit{remit: remit}
}
