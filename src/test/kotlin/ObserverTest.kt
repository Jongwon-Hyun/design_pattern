import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import observer.Messenger
import observer.sender.AppAlarmSender
import observer.sender.MailSender
import strategy.AbcBankRemit
import strategy.DefBankRemit
import strategy.fee.DefaultFee
import strategy.fee.Fee
import strategy.fee.PartnershipFee

class ObserverTest : FunSpec({
    test("observer run") {
        val messenger = Messenger()
        val mailSender = MailSender()
        val appAlarmSender = AppAlarmSender()

        messenger.subscribe(mailSender)
        messenger.subscribe(appAlarmSender)

        messenger.publish("Show me the Money!")

        messenger.unsubscribe(appAlarmSender)

        messenger.publish("Give me the Money!")
    }
})