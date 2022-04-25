package factory.product

import factory.product.part.Engine
import factory.product.part.Tire

class SuperTruck : Vehicle() {
    override var name = NAME
    override var engine: Engine = Engine.GASOLINE
    override var tire: Tire = Tire.OFFLOAD

    companion object {
        const val NAME: String = "Super Truck"
    }
}