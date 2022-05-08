package adapter.repository;

import adapter.Currency;
import adapter.ExchangeRateV2;

public class ExchangeRateV2Repository implements ExchangeRateV2 {
    @Override
    public double getExchangeRate(Currency from, Currency to) {
        return switch (from) {
            case USD -> fromUSD(to);
            case KRW -> fromKRW(to);
        };
    }

    private double fromUSD(Currency to) {
        return switch (to) {
            case KRW -> 1271.14;
            case USD -> 1;
        };
    }

    private double fromKRW(Currency to) {
        return switch (to) {
            case USD -> 0.00079;
            case KRW -> 1;
        };
    }
}
