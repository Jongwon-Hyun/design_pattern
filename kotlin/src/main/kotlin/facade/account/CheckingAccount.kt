package facade.account

class CheckingAccount(balance: Long) : Account(balance) {
    companion object {
        const val DEPOSIT_LIMIT: Long = 5_000_000
    }

    override fun deposit(amount: Long) {
        if (amount > DEPOSIT_LIMIT) {
            throw IllegalArgumentException("1회 입금 한도 초과")
        }

        addBalance(amount)
    }

    override fun withdraw(amount: Long) {
        minusBalance(amount)
    }
}