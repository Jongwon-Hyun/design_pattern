package abstract_factory.product

import abstract_factory.product.part.Engine
import abstract_factory.product.part.Option
import abstract_factory.product.part.Tire

abstract class Vehicle {

    abstract var name: String
    lateinit var engine: Engine
    lateinit var tire: Tire
    lateinit var options: List<Option?>

    abstract fun assembly()

    fun loadShip() {
        println("배에 선적")
    }
}