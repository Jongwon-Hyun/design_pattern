package custom_errors

type ApplicationError struct {
	Message string
	Status  int
}

func NewApplicationError(message string, status int) *ApplicationError {
	return &ApplicationError{Message: message, Status: status}
}

func (a ApplicationError) Error() string {
	return a.Message
}

type BadRequestError struct {
	Message string
}

func NewBadRequestError(message string) *BadRequestError {
	return &BadRequestError{Message: message}
}

func (b BadRequestError) Error() string {
	return b.Message
}
