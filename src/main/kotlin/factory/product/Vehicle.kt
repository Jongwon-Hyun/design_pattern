package factory.product

import factory.product.part.Engine
import factory.product.part.Tire

// TODO 추상 팩토리 패턴으로 다시 구현할 것!
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