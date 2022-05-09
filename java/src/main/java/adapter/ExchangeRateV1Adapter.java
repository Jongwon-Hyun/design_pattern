package adapter;

public class ExchangeRateV1Adapter implements ExchangeRateV2 {
    private final ExchangeRateV1 exchangeRateV1;

    public ExchangeRateV1Adapter(ExchangeRateV1 exchangeRateV1) {
        this.exchangeRateV1 = exchangeRateV1;
    }

    @Override
    public double getExchangeRate(Currency from, Currency to) {
        return switch (from) {
            case USD -> exchangeRateV1.fromUSD(to);
            case KRW -> exchangeRateV1.fromKRW(to);
        };
    }
}
