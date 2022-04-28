package abstract_factory.product.part

class OffloadVehiclePartFactory : VehiclePartFactory {
    override fun createEngine(): Engine {
        return Engine.GASOLINE
    }

    override fun createTire(): Tire {
        return Tire.OFFLOAD
    }

    override fun createOptions(): List<Option> {
        return listOf(Option.NAVIGATION, Option.AUDIO_SYSTEM)
    }
}