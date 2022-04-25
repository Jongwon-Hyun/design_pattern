package factory.product

import factory.product.part.Engine
import factory.product.part.Tire

class SuperBus : Vehicle() {
    override var name = NAME
    override var engine: Engine = Engine.HYBRID
    override var tire: Tire = Tire.NORMAL

    companion object {
        const val NAME: String = "Super Bus"
    }
}