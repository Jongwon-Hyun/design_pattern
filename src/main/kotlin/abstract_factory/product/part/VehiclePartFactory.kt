package abstract_factory.product.part

interface VehiclePartFactory {
    fun createEngine(): Engine
    fun createTire(): Tire
    fun createOptions(): List<Option>

}