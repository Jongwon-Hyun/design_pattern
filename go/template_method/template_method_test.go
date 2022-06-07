package template_method

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestTemplateMethod(t *testing.T) {
	t.Run("Test Template Method", func(t *testing.T) {
		controller := NewPostAccountController[PostAccountReqBody, PostAccountResBody, string]()
		reqBody, err := NewPostAccountReqBody("12345", "123")
		if err != nil {
			t.Error()
		}
		response := controller.CreateAccount(*reqBody)

		assert.Equal(t, 201, response.Status)
	})
}
