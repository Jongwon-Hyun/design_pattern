import abstract_factory.creator.SuperVehicleFactory
import abstract_factory.creator.UltraVehicleFactory
import abstract_factory.product.*
import abstract_factory.product.part.Engine
import abstract_factory.product.part.Option
import abstract_factory.product.part.Tire
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class AbstractFactoryTest : FunSpec({
    test("Abstract Factory Run") {
        val superVehicleFactory = SuperVehicleFactory()
        val ultraVehicleFactory = UltraVehicleFactory()

        val superBus = superVehicleFactory.orderVehicle(VehicleType.BUS)
        superBus.name shouldBe SuperBus.NAME
        superBus.engine shouldBe Engine.HYBRID
        superBus.tire shouldBe Tire.NORMAL
        superBus.options shouldContainAll listOf(Option.NAVIGATION, Option.CRUISE_CONTROL)

        val superTruck = superVehicleFactory.orderVehicle(VehicleType.TRUCK)
        superTruck.name shouldBe SuperTruck.NAME
        superTruck.engine shouldBe Engine.GASOLINE
        superTruck.tire shouldBe Tire.OFFLOAD
        superTruck.options.shouldBeEmpty()

        val ultraBus = ultraVehicleFactory.orderVehicle(VehicleType.BUS)
        ultraBus.name shouldBe UltraBus.NAME
        ultraBus.engine shouldBe Engine.GASOLINE
        ultraBus.tire shouldBe Tire.OFFLOAD
        ultraBus.options shouldContainAll listOf(Option.NAVIGATION, Option.AUDIO_SYSTEM)

        val ultraTruck = ultraVehicleFactory.orderVehicle(VehicleType.TRUCK)
        ultraTruck.name shouldBe UltraTruck.NAME
        ultraTruck.engine shouldBe Engine.HYBRID
        ultraTruck.tire shouldBe Tire.NORMAL
        superTruck.options.shouldBeEmpty()
    }
})