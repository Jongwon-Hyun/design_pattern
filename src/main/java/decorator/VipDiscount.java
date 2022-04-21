package decorator;

public class VipDiscount implements Discount{
    public static final double RATE = 0.05;
    public static final String HISTORY = "VIP 할인";

    @Override
    public double amountAfterDiscount(double amount) {
        return amount * RATE;
    }

    @Override
    public String history() {
        return HISTORY;
    }
}
