export abstract class Account {
    protected constructor(private balance: number) {}

    abstract deposit(amount: number): void;
    abstract withdraw(amount: number): void;

    getBalance(): number {
        return this.balance;
    }

    protected addBalance(amount: number) {
        this.balance += amount;
    }

    protected minusBalance(amount: number) {
        if (this.balance - amount < 0) {
            throw new Error("잔고 부족");
        }
        
        this.balance -= amount;
    }
}