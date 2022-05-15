import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import strategy.AbcBankRemit
import strategy.DefBankRemit
import strategy.fee.DefaultFee
import strategy.fee.PartnershipFee

class StrategyTest : FunSpec({
    test("Test Strategy") {
        val amount = 1000.0
        val defaultFee = amount * DefaultFee.FEE
        val partnershipFee = amount * PartnershipFee.FEE

        val abcBankRemit = AbcBankRemit(DefaultFee())
        val defBankRemit = DefBankRemit(PartnershipFee())

        val amountAbc = abcBankRemit.calculateAmount(amount)
        val amountDef = defBankRemit.calculateAmount(amount)

        amountAbc shouldBe amount + defaultFee
        amountDef shouldBe amount + partnershipFee
    }
})