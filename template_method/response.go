package template_method

type Response struct {
	Body   interface{}
	Status int
}

func NewResponse(body interface{}, status int) *Response {
	return &Response{Body: body, Status: status}
}
