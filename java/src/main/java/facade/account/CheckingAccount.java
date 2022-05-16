package facade.account;

public class CheckingAccount extends Account {
    private static final long DEPOSIT_LIMIT = 5_000_000;

    public CheckingAccount(long balance) {
        super(balance);
    }

    @Override
    public void deposit(long amount) {
        if (amount > DEPOSIT_LIMIT) {
            throw new IllegalArgumentException("1회 입금 한도 초과");
        }

        addBalance(amount);
    }

    @Override
    public void withdraw(long amount) {
        minusBalance(amount);
    }
}
