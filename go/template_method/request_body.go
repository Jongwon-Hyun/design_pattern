package template_method

import (
	"errors"
	"unicode/utf8"
)

type Requestable interface {
	PostAccountReqBody
}

type PostAccountReqBody struct {
	AccountNumber string
	BranchCode    string
}

func NewPostAccountReqBody(accountNumber string, branchCode string) (*PostAccountReqBody, error) {
	if utf8.RuneCountInString(accountNumber) != 5 {
		return nil, errors.New("invalid account number")
	}

	if utf8.RuneCountInString(branchCode) != 3 {
		return nil, errors.New("invalid branch code")
	}

	return &PostAccountReqBody{
		AccountNumber: accountNumber,
		BranchCode:    branchCode,
	}, nil
}
