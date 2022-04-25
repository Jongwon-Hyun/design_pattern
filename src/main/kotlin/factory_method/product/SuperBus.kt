package factory_method.product

import factory_method.product.part.Engine
import factory_method.product.part.Tire

class SuperBus : Vehicle() {
    override var name = NAME
    override var engine: Engine = Engine.HYBRID
    override var tire: Tire = Tire.NORMAL

    companion object {
        const val NAME: String = "Super Bus"
    }
}