package strategy;

import strategy.fee.Fee;

public abstract class Remit {
    private final Fee fee;

    public Remit(Fee fee) {
        this.fee = fee;
    }

    public abstract String createTransferMessage();

    public double calculateAmount(double amount) {
        return amount + calculateFee(amount);
    }

    private double calculateFee(double amount) {
        return this.fee.calculate(amount);
    }
}
