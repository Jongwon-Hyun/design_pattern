package factory.product

import factory.product.part.Engine
import factory.product.part.Tire

class UltraBus : Vehicle() {
    override var name = NAME
    override var engine: Engine = Engine.GASOLINE
    override var tire: Tire = Tire.NORMAL

    companion object {
        const val NAME: String = "Ultra Bus"
    }
}