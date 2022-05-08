package adapter.repository;

import adapter.Currency;
import adapter.ExchangeRateV1;

public class ExchangeRateV1Repository implements ExchangeRateV1 {
    public double fromUSD(Currency to) {
        return switch (to) {
            case KRW -> 1271.14;
            case USD -> 1;
        };
    }

    public double fromKRW(Currency to) {
        return switch (to) {
            case USD -> 0.00079;
            case KRW -> 1;
        };
    }
}
