package command;

import java.util.function.Consumer;

public class Transfer {
    private final Consumer<TransferParam> command;

    public Transfer(Consumer<TransferParam> command) {
        this.command = command;
    }

    public void start(TransferParam transferParam) {
        command.accept(transferParam);
    }
}
