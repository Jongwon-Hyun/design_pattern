package command

import (
	"errors"
	"fmt"
)

type abcBank struct{}

func NewAbcBank() *abcBank {
	return &abcBank{}
}

func (a abcBank) Transfer(transferParam TransferParam) error {
	fmt.Println("AbcBank 이체 시작")

	if !a.confirmAccount(transferParam.account) {
		return errors.New("계좌 번호를 확인해 주세요.")
	}

	transactionID := a.generateTransactionID()

	fmt.Printf(
		"%f 원을 이체 하였습니다. 거래 내역은 %s 로 확인해 주세요.\n", transferParam.amount, transactionID)
	fmt.Println("AbcBank 이체 종료")

	return nil
}

func (a abcBank) confirmAccount(account string) bool {
	fmt.Printf("%s 계좌를 확인했습니다.\n", account)
	return true
}

func (a abcBank) generateTransactionID() string {
	return "1234567890"
}

type xyzBank struct{}

func NewXyzBank() *xyzBank {
	return &xyzBank{}
}

func (x xyzBank) Transfer(transferParam TransferParam) {
	fmt.Println("XyzBank 이체 시작")

	fee := x.calculateFee(transferParam.amount)
	transferAmount := transferParam.amount - fee

	fmt.Printf(
		"%.3f 원을 이체 하였습니다.\n", transferAmount)
	fmt.Println("XyzBank 이체 종료")
}

func (x xyzBank) calculateFee(amount float64) float64 {
	return amount * 0.02
}
