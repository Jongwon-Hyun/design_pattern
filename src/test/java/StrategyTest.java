import org.junit.jupiter.api.Test;
import strategy.AbcBankRemit;
import strategy.DefBankRemit;
import strategy.Remit;
import strategy.fee.DefaultFee;
import strategy.fee.Fee;
import strategy.fee.PartnershipFee;
import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {

    @Test
    void strategyRun() {
        final var amount = 1000;
        final var defaultFee =  amount * Fee.DEFAULT_FEE;
        final var partnershipFee = amount * Fee.PARTNERSHIP_FEE;

        final Remit abcBankRemit = new AbcBankRemit(new DefaultFee());
        final Remit defBankRemit = new DefBankRemit(new PartnershipFee());

        final var amountAbc = abcBankRemit.calculateAmount(amount);
        final var amountDef = defBankRemit.calculateAmount(amount);

        assertEquals(amount + defaultFee, amountAbc);
        assertEquals(amount + partnershipFee, amountDef);
    }
}
