import io.kotest.core.spec.style.FunSpec
import observer.Messenger
import observer.sender.AppAlarmSender
import observer.sender.MailSender

class ObserverTest : FunSpec({
    test("Test Observer") {
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