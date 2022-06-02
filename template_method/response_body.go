package template_method

import "design_pattern/template_method/custom_errors"

type Responsible interface {
	PostAccountResBody | custom_errors.ErrorResponse
}

type PostAccountResBody struct {
	AccountNumber string
}

func NewPostAccountResBody(accountNumber string) *PostAccountResBody {
	return &PostAccountResBody{AccountNumber: accountNumber}
}
