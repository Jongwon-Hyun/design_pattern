package command.receiver;

import command.TransferParam;

import java.util.Objects;

public class AbcBank {
    public void transfer(TransferParam transferParam) {
        System.out.println("AbcBank 이체 시작");

        if (Objects.isNull(transferParam)) {
            throw new IllegalArgumentException("TransferParam required");
        }

        if (!confirmAccount(transferParam.account())) {
            throw new IllegalArgumentException("계좌 번호를 확인해 주세요.");
        }

        final var transactionID = generateTransactionID();

        final var message = String.format(
                "%f 원을 이체 하였습니다. 거래 내역은 %s 로 확인해 주세요.", transferParam.amount(), transactionID);
        System.out.println(message);
        System.out.println("AbcBank 이체 종료");
    }

    private boolean confirmAccount(String account) {
        System.out.println(account + " 계좌를 확인했습니다.");
        return true;
    }

    private String generateTransactionID() {
        return "1234567890";
    }
}
