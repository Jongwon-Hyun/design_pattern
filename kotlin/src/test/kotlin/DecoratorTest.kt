import decorator.DiscountBuilder
import decorator.DiscountType
import decorator.StudentDiscount
import decorator.VipDiscount
import decorator.decorator.TenOrderDiscount
import decorator.decorator.WelcomeDiscount
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe


class DecoratorTest : FunSpec({
    test("Test Decorator") {
        val amount = 1000.0

        val student = DiscountBuilder(DiscountType.STUDENT)
        val studentDiscount = student.discount
        val studentAmount = studentDiscount.amountAfterDiscount(amount)
        val studentHistory = studentDiscount.history()
        studentAmount shouldBe amount * StudentDiscount.RATE
        studentHistory shouldBe StudentDiscount.HISTORY


        val vip = DiscountBuilder(DiscountType.VIP)
        val vipDiscount = vip.discount
        val vipAmount = vipDiscount.amountAfterDiscount(amount)
        val vipHistory = vipDiscount.history()
        vipAmount shouldBe amount * VipDiscount.RATE
        vipHistory shouldBe VipDiscount.HISTORY


        val studentWithWelcome = DiscountBuilder(DiscountType.STUDENT)
            .welcomeDiscount()
        val studentWithWelcomeDiscount = studentWithWelcome.discount
        val studentWithWelcomeAmount = studentWithWelcomeDiscount.amountAfterDiscount(amount)
        val studentWithWelcomeHistory = studentWithWelcomeDiscount.history()
        studentWithWelcomeAmount shouldBe amount * StudentDiscount.RATE * WelcomeDiscount.RATE
        studentWithWelcomeHistory shouldBe "${StudentDiscount.HISTORY} ${WelcomeDiscount.HISTORY}"


        val studentWithWelcomeAndTenOrder = DiscountBuilder(DiscountType.STUDENT)
            .welcomeDiscount()
            .tenOrderDiscount()
        val studentWithWelcomeAndTenOrderDiscount = studentWithWelcomeAndTenOrder.discount
        val studentWithWelcomeAndTenOrderAmount = studentWithWelcomeAndTenOrderDiscount.amountAfterDiscount(amount)
        val studentWithWelcomeAndTenOrderHistory = studentWithWelcomeAndTenOrderDiscount.history()
        studentWithWelcomeAndTenOrderAmount shouldBe
                amount * StudentDiscount.RATE * WelcomeDiscount.RATE * TenOrderDiscount.RATE
        studentWithWelcomeAndTenOrderHistory shouldBe
                "${StudentDiscount.HISTORY} ${WelcomeDiscount.HISTORY} ${TenOrderDiscount.HISTORY}"


        val vipWithTenOrder = DiscountBuilder(DiscountType.VIP)
            .tenOrderDiscount()
        val vipWithTenOrderDiscount = vipWithTenOrder.discount
        val vipWithTenOrderAmount = vipWithTenOrderDiscount.amountAfterDiscount(amount)
        val vipWithTenOrderHistory = vipWithTenOrderDiscount.history()
        vipWithTenOrderAmount shouldBe amount * VipDiscount.RATE * TenOrderDiscount.RATE
        vipWithTenOrderHistory shouldBe "${VipDiscount.HISTORY} ${TenOrderDiscount.HISTORY}"


        val vipWithTenOrderAndWelcome = DiscountBuilder(DiscountType.VIP)
            .tenOrderDiscount()
            .welcomeDiscount()
        val vipWithTenOrderAndWelcomeDiscount = vipWithTenOrderAndWelcome.discount
        val vipWithTenOrderAndWelcomeAmount = vipWithTenOrderAndWelcomeDiscount.amountAfterDiscount(amount)
        val vipWithTenOrderAndWelcomeHistory = vipWithTenOrderAndWelcomeDiscount.history()
        vipWithTenOrderAndWelcomeAmount shouldBe
                amount * VipDiscount.RATE * TenOrderDiscount.RATE * WelcomeDiscount.RATE
        vipWithTenOrderAndWelcomeHistory shouldBe
                "${VipDiscount.HISTORY} ${TenOrderDiscount.HISTORY} ${WelcomeDiscount.HISTORY}"
    }
})