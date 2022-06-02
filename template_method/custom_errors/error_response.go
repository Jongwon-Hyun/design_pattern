package custom_errors

type ErrorResponse struct {
	Message string
}

func NewErrorResponse(message string) *ErrorResponse {
	return &ErrorResponse{Message: message}
}
