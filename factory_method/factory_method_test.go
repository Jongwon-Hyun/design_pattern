package factory__test

import (
	"design_pattern/factory_method/creator"
	"design_pattern/factory_method/product"
	"design_pattern/factory_method/product/part"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestFactoryMethod(t *testing.T) {
	t.Run("Test Factory Method", func(t *testing.T) {
		superVehicleFactory := creator.NewSuperVehicleFactory()
		ultraVehicleFactory := creator.NewUltraVehicleFactory()

		superBus, err := superVehicleFactory.OrderVehicle(product.Bus)
		if err != nil {
			t.Error(err)
		}
		assert.Equal(t, product.SuperBusName, superBus.GetName())
		assert.Equal(t, part.EngineHybrid, superBus.GetEngine())
		assert.Equal(t, part.TireNormal, superBus.GetTire())

		superTruck, err := superVehicleFactory.OrderVehicle(product.Truck)
		if err != nil {
			t.Error(err)
		}
		assert.Equal(t, product.SuperTruckName, superTruck.GetName())
		assert.Equal(t, part.EngineGasoline, superTruck.GetEngine())
		assert.Equal(t, part.TireOffload, superTruck.GetTire())

		ultraBus, err := ultraVehicleFactory.OrderVehicle(product.Bus)
		if err != nil {
			t.Error(err)
		}
		assert.Equal(t, product.UltraBusName, ultraBus.GetName())
		assert.Equal(t, part.EngineGasoline, ultraBus.GetEngine())
		assert.Equal(t, part.TireNormal, ultraBus.GetTire())

		ultraTruck, err := ultraVehicleFactory.OrderVehicle(product.Truck)
		if err != nil {
			t.Error(err)
		}
		assert.Equal(t, product.UltraTruckName, ultraTruck.GetName())
		assert.Equal(t, part.EngineHybrid, ultraTruck.GetEngine())
		assert.Equal(t, part.TireOffload, ultraTruck.GetTire())
	})
}
