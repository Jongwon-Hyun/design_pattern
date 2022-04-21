package decorator.decorator;

import decorator.Discount;

public class TenOrderDiscount implements Discount {
    public static final double RATE = 0.02;
    public static final String HISTORY = "10번 주문 할인";
    private final Discount discount;

    public TenOrderDiscount(Discount discount) {
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
