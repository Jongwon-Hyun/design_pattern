package facade.account;

public abstract class Account {
    private long balance;

    protected Account(long balance) {
        this.balance = balance;
    }

    public abstract void deposit(long amount);

    public abstract void withdraw(long amount);

    public long getBalance() {
        return balance;
    }

    protected void addBalance(long amount) {
        balance += amount;
    }

    protected void minusBalance(long amount) {
        if (balance - amount < 0) {
            throw new IllegalArgumentException("잔고 부족");
        }
        balance -= amount;
    }
}
