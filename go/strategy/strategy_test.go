package strategy

import (
	"design_pattern/strategy/fee"
	"design_pattern/strategy/remit"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestStrategy(t *testing.T) {
	t.Run("Strategy run", func(t *testing.T) {
		var amount float64 = 1000
		defaultFee := amount * fee.DefaultFee
		partnershipFee := amount * fee.PartnershipFee

		abcBankRemit := remit.NewAbcBankRemit(fee.NewDefaultFee())
		defBankRemit := remit.NewDefBankRemit(fee.NewPartnershipFee())

		amountAbc := abcBankRemit.CalculateAmount(amount)
		amountDef := defBankRemit.CalculateAmount(amount)

		assert.Equal(t, amount+defaultFee, amountAbc)
		assert.Equal(t, amount+partnershipFee, amountDef)
	})
}
