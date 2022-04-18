package strategy.fee;

public interface Fee {
    double DEFAULT_FEE = 0.03;
    double PARTNERSHIP_FEE = 0.01;

    double calculate(double amount);
}