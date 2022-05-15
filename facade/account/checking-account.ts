import { Account } from "./account";

export class CheckingAccount extends Account {
    private readonly DEPOSIT_LIMIT: number = 5_000_000;
    constructor(balance: number) {
        super(balance);
    }

    deposit(amount: number) {
        if (amount > this.DEPOSIT_LIMIT) {
            throw new Error("1회 입금 한도 초과");
        }

        this.addBalance(amount);
    }

    withdraw(amount: number) {
        this.minusBalance(amount);
    }
}