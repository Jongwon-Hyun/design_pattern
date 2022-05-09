import adapter.Currency;
import adapter.ExchangeRateV1Adapter;
import adapter.repository.ExchangeRateV1Repository;
import adapter.repository.ExchangeRateV2Repository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdapterTest {
    @Test
    void testAdapter() {
        final var exchangeRateV1 = new ExchangeRateV1Repository();
        final var exchangeRateV2 = new ExchangeRateV2Repository();
        final var exchangeRateV1Adapter = new ExchangeRateV1Adapter(exchangeRateV1);

        final var v1USDToKRW = exchangeRateV1.fromUSD(Currency.KRW);
        assertEquals(1271.14, v1USDToKRW);

        final var v2USDToKRW = exchangeRateV2.getExchangeRate(Currency.USD, Currency.KRW);
        assertEquals(1271.14, v2USDToKRW);

        final var adapterUSDToKRW = exchangeRateV1Adapter.getExchangeRate(Currency.USD, Currency.KRW);
        assertEquals(1271.14, adapterUSDToKRW);


        final var v1KRWToUSD = exchangeRateV1.fromKRW(Currency.USD);
        assertEquals(0.00079, v1KRWToUSD);

        final var v2KRWToUSD = exchangeRateV2.getExchangeRate(Currency.KRW, Currency.USD);
        assertEquals(0.00079, v2KRWToUSD);

        final var adapterKRWToUSD = exchangeRateV1Adapter.getExchangeRate(Currency.KRW, Currency.USD);
        assertEquals(0.00079, adapterKRWToUSD);
    }
}
