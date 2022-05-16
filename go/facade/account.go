package facade

import "errors"

type Account interface {
	Deposit(amount int) error
	Withdraw(amount int) error
	GetBalance() int
}

type account struct {
	balance int
}

func newAccount(balance int) *account {
	return &account{balance: balance}
}

func (a account) GetBalance() int {
	return a.balance
}

func (a *account) addBalance(amount int) {
	a.balance += amount
}

func (a *account) minusBalance(amount int) error {
	if a.balance-amount < 0 {
		return errors.New("잔고 부족")
	}

	a.balance -= amount

	return nil
}

type checkingAccount struct {
	*account
	depositLimit int
}

func NewCheckingAccount(balance int) Account {
	return &checkingAccount{account: newAccount(balance), depositLimit: 5_000_000}
}

func (c *checkingAccount) Deposit(amount int) error {
	if amount > c.depositLimit {
		return errors.New("1회 입금 한도 초과")
	}

	c.addBalance(amount)

	return nil
}

func (c *checkingAccount) Withdraw(amount int) error {
	err := c.minusBalance(amount)
	if err != nil {
		return err
	}

	return nil
}
