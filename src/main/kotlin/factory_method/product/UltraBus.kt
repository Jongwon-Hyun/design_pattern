package factory_method.product

import factory_method.product.part.Engine
import factory_method.product.part.Tire

class UltraBus : Vehicle() {
    override var name = NAME
    override var engine: Engine = Engine.GASOLINE
    override var tire: Tire = Tire.NORMAL

    companion object {
        const val NAME: String = "Ultra Bus"
    }
}