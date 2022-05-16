import facade.Bank;
import facade.account.CheckingAccount;
import facade.log.ConsoleLog;
import facade.notification.Notification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FacadeTest {

    @Test
    void testFacade() {
        final var bank = new Bank(
                new CheckingAccount(10_000_000),
                new ConsoleLog(),
                new Notification()
        );

        bank.depositWithLogAndNotification(5000);
        assertEquals(10_005_000, bank.getBalance());

        bank.withdrawWithLogAndNotification(5000);
        assertEquals(10_000_000, bank.getBalance());

        assertThrows(IllegalArgumentException.class, () ->
                bank.depositWithLogAndNotification(5_000_001)
        );

        assertThrows(IllegalArgumentException.class, () ->
                bank.withdrawWithLogAndNotification(bank.getBalance() + 1)
        );
    }
}
