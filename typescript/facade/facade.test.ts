import { CheckingAccount } from "./account/checking-account";
import { Bank } from "./bank";
import { ConsoleLog } from "./log/console-log";
import { Notification } from "./notification/notification";

test('Test Facade', () => {
    const bank = new Bank(
        new CheckingAccount(10_000_000),
        new ConsoleLog(),
        new Notification()
    );

    bank.depositWithLogAndNotification(5000);
    expect(bank.getBalance()).toEqual(10_005_000);

    bank.withdrawWithLogAndNotification(5000);
    expect(bank.getBalance()).toEqual(10_000_000);

    expect(() => bank.depositWithLogAndNotification(5_000_001)).toThrow(Error)

    expect(() => bank.withdrawWithLogAndNotification(bank.getBalance() + 1)).toThrow(Error)
});