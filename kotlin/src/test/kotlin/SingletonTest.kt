import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs
import singleton.Singleton

class SingletonTest : FunSpec({
    test("Test Singleton") {
        val instanceA = Singleton
        val instanceB = Singleton

        instanceA shouldBeSameInstanceAs instanceB

        Singleton.function() shouldBe Singleton.field
    }
})