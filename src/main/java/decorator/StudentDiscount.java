package decorator;

public class StudentDiscount implements Discount {
    public static final double RATE = 0.03;
    public static final String HISTORY = "학생 할인";

    @Override
    public double amountAfterDiscount(double amount) {
        return amount * RATE;
    }

    @Override
    public String history() {
        return HISTORY;
    }
}
