package singleton

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestSingleton(t *testing.T) {
	t.Run("Test Singleton", func(t *testing.T) {
		instanceA := GetInstance()
		instanceB := GetInstance()

		assert.Same(t, instanceA, instanceB)
	})
}
