import { Messenger } from "./messenger";
import { AppAlarmSender } from "./sender/app-alarm-sender";
import { MailSender } from "./sender/mail-sender";

test('Test Observer', () => {
    const messenger = new Messenger();
    const mailSender = new MailSender();
    const appAlarmSender = new AppAlarmSender();

    messenger.subscribe(mailSender);
    messenger.subscribe(appAlarmSender);

    messenger.publish("Show me the Money!");

    messenger.unsubscribe(appAlarmSender);

    messenger.publish("Give me the Money!");
});