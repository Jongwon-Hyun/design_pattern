package abstract_factory.product

import abstract_factory.product.part.VehiclePartFactory

class SuperBus(private val vehiclePartFactory: VehiclePartFactory) : Vehicle() {
    override var name = NAME

    override fun assembly() {
        engine = vehiclePartFactory.createEngine()
        tire = vehiclePartFactory.createTire()
        options = vehiclePartFactory.createOptions()
    }

    companion object {
        const val NAME: String = "Super Bus"
    }
}