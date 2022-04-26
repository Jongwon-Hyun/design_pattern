package factory_method.product

import factory_method.product.part.Engine
import factory_method.product.part.Tire

class SuperTruck : Vehicle() {
    override var name = NAME
    override var engine: Engine = Engine.GASOLINE
    override var tire: Tire = Tire.OFFLOAD

    companion object {
        const val NAME: String = "Super Truck"
    }
}