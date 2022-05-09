package adapter;

public interface ExchangeRateV1 {
    double fromUSD(Currency to);

    double fromKRW(Currency to);
}
