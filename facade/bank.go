package facade

import "strconv"

type bank struct {
	account      Account
	log          Log
	notification *Notification
}

func NewBank(account Account, log Log, notification *Notification) *bank {
	return &bank{account: account, log: log, notification: notification}
}

func (b bank) DepositWithLogAndNotification(amount int) error {
	err := b.account.Deposit(amount)
	if err != nil {
		b.log.Fatal("입금 실패, 원인: " + err.Error())
		return err
	}

	b.log.Info(strconv.Itoa(amount) + "원을 입금 했습니다.")
	b.log.Info("잔고는 " + strconv.Itoa(b.GetBalance()) + "원 입니다.")

	b.notification.SendEmail(strconv.Itoa(amount) + "원을 입금 했습니다.")
	b.notification.SendAppPush(strconv.Itoa(amount) + "원을 입금 했습니다.")

	return nil
}

func (b bank) WithdrawWithLogAndNotification(amount int) error {
	err := b.account.Withdraw(amount)
	if err != nil {
		b.log.Fatal("출금 실패, 원인: " + err.Error())
		return err
	}

	b.log.Info(strconv.Itoa(amount) + "원을 출금 했습니다.")
	b.log.Info("잔고는 " + strconv.Itoa(b.GetBalance()) + "원 입니다.")

	b.notification.SendEmail(strconv.Itoa(amount) + "원을 출금 했습니다.")
	b.notification.SendAppPush(strconv.Itoa(amount) + "원을 출금 했습니다.")

	return nil
}

func (b bank) GetBalance() int {
	return b.account.GetBalance()
}
