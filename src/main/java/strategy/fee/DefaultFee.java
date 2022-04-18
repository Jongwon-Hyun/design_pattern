package strategy.fee;

public class DefaultFee implements Fee {
    @Override
    public double calculate(double amount) {
        return amount * DEFAULT_FEE;
    }
}
