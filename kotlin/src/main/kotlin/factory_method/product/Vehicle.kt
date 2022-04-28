package factory_method.product

import factory_method.product.part.Engine
import factory_method.product.part.Tire

abstract class Vehicle {

    abstract var name: String
    abstract var engine: Engine
    abstract var tire: Tire

    fun assembly() {
        println("$engine 엔진을 장착")
        println("$tire 타이어를 장착")
    }

    fun loadShip() {
        println("배에 선적")
    }
}