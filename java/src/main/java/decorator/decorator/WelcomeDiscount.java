package decorator.decorator;

import decorator.Discount;

public class WelcomeDiscount implements Discount {
    public static final double RATE = 0.01;
    public static final String HISTORY = "웰컴 할인";
    private final Discount discount;

    public WelcomeDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public double amountAfterDiscount(double amount) {
        return discount.amountAfterDiscount(amount) * RATE;
    }

    @Override
    public String history() {
        return discount.history() + " " + HISTORY;
    }
}
