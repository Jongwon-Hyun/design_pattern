package facade;

import facade.account.Account;
import facade.log.Log;
import facade.notification.Notification;

public class Bank {
    private final Account account;
    private final Log log;
    private final Notification notification;

    public Bank(Account account, Log log, Notification notification) {
        this.account = account;
        this.log = log;
        this.notification = notification;
    }

    public void depositWithLogAndNotification(long amount) {
        try {
            account.deposit(amount);
            log.info(amount + "원을 입금 했습니다.");
            log.info("잔고는 " + getBalance() + "원 입니다.");

            notification.sendEmail(amount + "원을 입금 했습니다.");
            notification.sendAppPush(amount + "원을 입금 했습니다.");
        } catch (Exception e) {
            log.fatal("입금 실패, 원인: " + e.getMessage());
            throw e;
        }
    }

    public void withdrawWithLogAndNotification(long amount) {
        try {
            account.withdraw(amount);
            log.info(amount + "원을 출금 했습니다.");
            log.info("잔고는 " + getBalance() + "원 입니다.");

            notification.sendEmail(amount + "원을 출금 했습니다.");
            notification.sendAppPush(amount + "원을 출금 했습니다.");
        } catch (Exception e) {
            log.fatal("출금 실패, 원인: " + e.getMessage());
            throw e;
        }
    }

    public long getBalance() {
        return account.getBalance();
    }
}
