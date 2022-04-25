package factory.product

import factory.product.part.Engine
import factory.product.part.Tire

class UltraTruck : Vehicle() {
    override var name = NAME
    override var engine: Engine = Engine.HYBRID
    override var tire: Tire = Tire.OFFLOAD

    companion object {
        const val NAME: String = "Ultra Truck"
    }
}