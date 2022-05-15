import facade.Bank
import facade.account.CheckingAccount
import facade.log.ConsoleLog
import facade.notification.Notification
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FacadeTest : FunSpec({
    test("Test Facade") {
        val bank = Bank(
            CheckingAccount(10_000_000),
            ConsoleLog(),
            Notification()
        )

        bank.depositWithLogAndNotification(5000)
        bank.getBalance() shouldBe 10_005_000

        bank.withdrawWithLogAndNotification(5000)
        bank.getBalance() shouldBe 10_000_000

        shouldThrow<IllegalArgumentException> {
            bank.depositWithLogAndNotification(5000001)
        }

        shouldThrow<IllegalArgumentException> {
            bank.withdrawWithLogAndNotification(bank.getBalance() + 1)
        }
    }
})