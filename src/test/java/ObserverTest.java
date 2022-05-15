import observer.Messenger;
import observer.sender.AppAlarmSender;
import observer.sender.MailSender;
import org.junit.jupiter.api.Test;

public class ObserverTest {
    @Test
    void testObserver() {
        final var messenger = new Messenger();
        final var mailSender = new MailSender();
        final var appAlarmSender = new AppAlarmSender();

        messenger.subscribe(mailSender);
        messenger.subscribe(appAlarmSender);

        messenger.publish("Show me the Money!!");

        messenger.unsubscribe(appAlarmSender);

        messenger.publish("Give me the Money!");
    }
}
