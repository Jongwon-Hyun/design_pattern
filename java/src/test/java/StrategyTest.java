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
    void StrategyRun() {
        var amount = 1000;
        var defaultFee =  1000 * Fee.DEFAULT_FEE;
        var partnershipFee = 1000 * Fee.PARTNERSHIP_FEE;

        Remit abcBankRemit = new AbcBankRemit(new DefaultFee());
        Remit defBankRemit = new DefBankRemit(new PartnershipFee());

        var amountAbc = abcBankRemit.calculateAmount(amount);
        var amountDef = defBankRemit.calculateAmount(amount);

        assertEquals(amount + defaultFee, amountAbc);
        assertEquals(amount + partnershipFee, amountDef);
    }
}
