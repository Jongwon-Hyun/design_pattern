package command.receiver;

import command.TransferParam;

import java.util.Objects;

public class XyzBank {
    public void transfer(TransferParam transferParam) {
        System.out.println("XyxBank 이체 시작");

        if (Objects.isNull(transferParam)) {
            throw new IllegalArgumentException("TransferParam required");
        }

        final var fee = calculateFee(transferParam.amount());
        final var transferAmount = transferParam.amount() - fee;

        var message = String.format("%.3f 원을 이체 했습니다.", transferAmount);
        System.out.println(message);
        System.out.println("XyxBank 이체 종료");
    }

    private double calculateFee(double amount) {
        return amount * 0.02;
    }
}
