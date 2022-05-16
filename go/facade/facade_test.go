package facade

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestFacade(t *testing.T) {
	t.Run("Test Facade", func(t *testing.T) {
		bank := NewBank(
			NewCheckingAccount(10_000_000),
			NewConsoleLog(),
			NewNotification(),
		)

		err := bank.DepositWithLogAndNotification(5000)
		if err != nil {
			t.Error(err)
		}
		assert.Equal(t, 10_005_000, bank.GetBalance())

		err = bank.WithdrawWithLogAndNotification(5000)
		if err != nil {
			t.Error(err)
		}
		assert.Equal(t, 10_000_000, bank.GetBalance())

		err = bank.DepositWithLogAndNotification(5_000_001)
		assert.NotNil(t, err)
		assert.NotEmpty(t, err.Error())

		err = bank.WithdrawWithLogAndNotification(bank.GetBalance() + 1)
		assert.NotNil(t, err)
		assert.NotEmpty(t, err.Error())
	})
}
