import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import strategy.AbcBankRemit
import strategy.DefBankRemit
import strategy.fee.DefaultFee
import strategy.fee.Fee
import strategy.fee.PartnershipFee

class StrategyTest : FunSpec({
    test("strategy run") {
        val amount = 1000.0
        val defaultFee = amount * Fee.DEFAULT_FEE
        val partnershipFee = amount * Fee.PARTNERSHIP_FEE

        val abcBankRemit = AbcBankRemit(DefaultFee())
        val defBankRemit = DefBankRemit(PartnershipFee())

        val amountAbc = abcBankRemit.calculateAmount(amount)
        val amountDef = defBankRemit.calculateAmount(amount)

        amountAbc shouldBe amount + defaultFee
        amountDef shouldBe amount + partnershipFee
    }
})