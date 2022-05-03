import command.Transfer;
import command.TransferParam;
import command.receiver.AbcBank;
import command.receiver.XyzBank;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class CommandTest {
    @Test
    void testCommand() {
        final var queue = new LinkedList<Transfer>();

        final var abcBank = new AbcBank();
        final var transferToAbcBank = new Transfer(abcBank::transfer);
        queue.offer(transferToAbcBank);

        final var xyzBank = new XyzBank();
        final var transferToXyxBank = new Transfer(xyzBank::transfer);
        queue.offer(transferToXyxBank);

        while (!queue.isEmpty()) {
            var transfer = queue.poll();
            transfer.start(new TransferParam(123.45, "012345"));
        }
    }
}
