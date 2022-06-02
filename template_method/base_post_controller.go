package template_method

import (
	"design_pattern/template_method/custom_errors"
	"errors"
)

type IBasePostController[RQ Requestable, RS Responsible, Dto any] interface {
	MapToDto(requestBody RQ) Dto
	DoService(dto Dto) RS
	CreateResponse(responseBody RS) *Response
}

type BasePostController[RQ Requestable, RS Responsible, Dto any] struct {
	IBasePostController[RQ, RS, Dto]
}

func (b BasePostController[RQ, RS, Dto]) Execute(requestBody RQ) *Response {
	err := b.CheckRequest(requestBody)
	var badRequestError *custom_errors.BadRequestError
	var applicationError *custom_errors.ApplicationError
	if err != nil {
		switch {
		case errors.As(err, &badRequestError):
			return b.createErrorResponse(badRequestError.Error(), 400)
		case errors.As(err, &applicationError):
			return b.createErrorResponse(applicationError.Error(), applicationError.Status)
		default:
			return b.createErrorResponse(err.Error(), 500)
		}
	}

	return b.CreateResponse(b.DoService(b.MapToDto(requestBody)))
}

// CheckRequest Hook Method
func (b BasePostController[RQ, RS, Dto]) CheckRequest(requestBody RQ) error {
	return nil
}

func (b BasePostController[RQ, RS, Dto]) createErrorResponse(message string, status int) *Response {
	return NewResponse(custom_errors.NewErrorResponse(message), status)
}
