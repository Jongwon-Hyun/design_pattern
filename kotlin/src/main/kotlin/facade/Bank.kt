package facade

import facade.account.Account
import facade.log.Log
import facade.notification.Notification

class Bank(private val account: Account, private val log: Log, private val notification: Notification) {
    fun depositWithLogAndNotification(amount: Long) {
        try {
            account.deposit(amount)
            log.info("${amount}원을 입금 했습니다.")
            log.info("잔고는 ${getBalance()}원 입니다.")

            notification.sendEmail("${amount}원을 입금 했습니다.")
            notification.sendAppPush("${amount}원을 입금 했습니다.")
        } catch (e: Exception) {
            log.fatal("입금 실패, 원인: ${e.message}")
            throw e
        }
    }

    fun withdrawWithLogAndNotification(amount: Long) {
        try {
            account.withdraw(amount)
            log.info("${amount}원을 출금 했습니다.")
            log.info("잔고는 ${getBalance()}원 입니다.")

            notification.sendEmail("${amount}원을 출금 했습니다.")
            notification.sendAppPush("${amount}원을 출금 했습니다.")
        } catch (e: Exception) {
            log.fatal("출금 실패, 원인: ${e.message}")
            throw e
        }
    }

    fun getBalance(): Long {
        return account.getBalance()
    }
}