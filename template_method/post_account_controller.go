package template_method

type PostAccountController[RQ PostAccountReqBody, RS PostAccountResBody, Dto string] struct {
	*BasePostController[RQ, RS, Dto]
	dto      Dto
	response RS
}

func NewPostAccountController[RQ PostAccountReqBody, RS PostAccountResBody, Dto string]() *PostAccountController[RQ, RS, Dto] {
	postAccountController := &PostAccountController[RQ, RS, Dto]{BasePostController: &BasePostController[RQ, RS, Dto]{}}
	postAccountController.IBasePostController = postAccountController
	return postAccountController
}

func (p PostAccountController[RQ, RS, Dto]) CreateAccount(requestBody RQ) *Response {
	return p.BasePostController.Execute(requestBody)
}

func (p PostAccountController[RQ, RS, Dto]) MapToDto(requestBody RQ) Dto {
	reqBody := PostAccountReqBody(requestBody)
	return Dto(reqBody.BranchCode + reqBody.AccountNumber)
}

func (p *PostAccountController[RQ, RS, Dto]) DoService(accountNumber Dto) RS {
	return RS(*NewPostAccountResBody(string(accountNumber)))
}

func (p PostAccountController[RQ, RS, Dto]) CreateResponse(responseBody RS) *Response {
	return NewResponse(responseBody, 201)
}
