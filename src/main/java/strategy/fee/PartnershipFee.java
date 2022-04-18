package strategy.fee;

public class PartnershipFee implements Fee {
    @Override
    public double calculate(double amount) {
        return amount * PARTNERSHIP_FEE;
    }
}
