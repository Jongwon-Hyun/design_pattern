package abstract_factory.product.part

class CityVehiclePartFactory : VehiclePartFactory {
    override fun createEngine(): Engine {
        return Engine.HYBRID
    }

    override fun createTire(): Tire {
        return Tire.NORMAL
    }

    override fun createOptions(): List<Option> {
        return listOf(Option.NAVIGATION, Option.CRUISE_CONTROL)
    }

}