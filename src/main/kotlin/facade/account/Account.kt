package facade.account

abstract class Account(private var balance: Long) {
    abstract fun deposit(amount: Long)
    abstract fun withdraw(amount: Long)

    fun getBalance(): Long {
        return balance
    }

    protected fun addBalance(amount: Long) {
        balance += amount
    }

    protected fun minusBalance(amount: Long) {
        if (balance - amount < 0) {
            throw IllegalArgumentException("잔고 부족")
        }

        balance -= amount
    }
}