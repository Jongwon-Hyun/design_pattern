package decorator;

public interface Discount {
    double amountAfterDiscount(double amount);
    String history();
}
