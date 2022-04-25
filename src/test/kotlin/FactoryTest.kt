import factory.creator.SuperVehicleFactory
import factory.creator.UltraVehicleFactory
import factory.product.*
import factory.product.part.Engine
import factory.product.part.Tire
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FactoryTest : FunSpec({
    test("Factory Method Run") {
        val superVehicleFactory = SuperVehicleFactory()
        val ultraVehicleFactory = UltraVehicleFactory()

        val superBus = superVehicleFactory.orderVehicle(VehicleType.BUS)
        superBus.name shouldBe SuperBus.NAME
        superBus.engine shouldBe Engine.HYBRID
        superBus.tire shouldBe Tire.NORMAL

        val superTruck = superVehicleFactory.orderVehicle(VehicleType.TRUCK)
        superTruck.name shouldBe SuperTruck.NAME
        superTruck.engine shouldBe Engine.GASOLINE
        superTruck.tire shouldBe Tire.OFFLOAD

        val ultraBus = ultraVehicleFactory.orderVehicle(VehicleType.BUS)
        ultraBus.name shouldBe UltraBus.NAME
        ultraBus.engine shouldBe Engine.GASOLINE
        ultraBus.tire shouldBe Tire.NORMAL

        val ultraTruck = ultraVehicleFactory.orderVehicle(VehicleType.TRUCK)
        ultraTruck.name shouldBe UltraTruck.NAME
        ultraTruck.engine shouldBe Engine.HYBRID
        ultraTruck.tire shouldBe Tire.OFFLOAD
    }
})