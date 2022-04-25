package factory_method.product

import factory_method.product.part.Engine
import factory_method.product.part.Tire

class UltraTruck : Vehicle() {
    override var name = NAME
    override var engine: Engine = Engine.HYBRID
    override var tire: Tire = Tire.OFFLOAD

    companion object {
        const val NAME: String = "Ultra Truck"
    }
}