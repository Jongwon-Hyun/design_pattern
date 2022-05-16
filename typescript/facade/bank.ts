import { Account } from "./account/account";
import { Log } from "./log/log";
import { Notification } from "./notification/notification"

export class Bank {
    constructor(
        private readonly account: Account,
        private readonly log: Log,
        private readonly notification: Notification,
    ) {}

    depositWithLogAndNotification(amount: number): void {
        try {
            this.account.deposit(amount);
            this.log.info(`${amount}원을 입금 했습니다.`);
            this.log.info(`잔고는 ${this.getBalance()}원 입니다.`);

            this.notification.sendEmail(`${amount}원을 입금 했습니다.`);
            this.notification.sendAppPush(amount + "원을 입금 했습니다.");
        } catch (e) {
            this.log.fatal(`입금 실패, 원인: ${e.getMessage()}`);
            throw e;
        }
    }

    withdrawWithLogAndNotification(amount: number) {
        try {
            this.account.withdraw(amount);
            this.log.info(`${amount}원을 출금 했습니다.`);
            this.log.info(`잔고는 ${this.getBalance()}원 입니다.`);

            this.notification.sendEmail(`${amount}원을 출금 했습니다.`);
            this.notification.sendAppPush(`${amount}원을 출금 했습니다.`);
        } catch (e) {
            this.log.fatal(`출금 실패, 원인: ${e.getMessage()}`);
            throw e;
        }
    }

    getBalance(): number {
        return this.account.getBalance();
    }
}