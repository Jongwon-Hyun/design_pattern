import { KRW, USD } from "./currency";
import { ExchangeRateV1Adapter } from "./exchange-rate-v1-adapter";
import { ExchangeRateV1Repository } from "./repository/exchange-rate-v1-repository";
import { ExchangeRateV2Repository } from "./repository/exchange-rate-v2-repository";

test('Adapter Run', () => {
    const exchangeRateV1 = new ExchangeRateV1Repository();
    const exchangeRateV2 = new ExchangeRateV2Repository();
    const exchangeRateV1Adapter = new ExchangeRateV1Adapter(exchangeRateV1);

    const v1USDToKRW = exchangeRateV1.fromUSD(KRW);
    expect(v1USDToKRW).toEqual(1271.14);
    
    const v2USDToKRW = exchangeRateV2.getExchangeRate(USD, KRW);
    expect(v2USDToKRW).toEqual(1271.14);

    const adapterUSDToKRW = exchangeRateV1Adapter.getExchangeRate(USD, KRW);
    expect(v2USDToKRW).toEqual(1271.14);

    
    const v1KRWToUSD = exchangeRateV1.fromKRW(USD);
    expect(v1KRWToUSD).toEqual(0.00079);
    
    const v2KRWToUSD = exchangeRateV2.getExchangeRate(KRW, USD);
    expect(v2KRWToUSD).toEqual(0.00079);

    const adapterKRWToUSD = exchangeRateV1Adapter.getExchangeRate(KRW, USD);
    expect(adapterKRWToUSD).toEqual(0.00079);
});