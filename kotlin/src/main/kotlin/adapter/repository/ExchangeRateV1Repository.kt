package adapter.repository

import adapter.Currency
import adapter.ExchangeRateV1

class ExchangeRateV1Repository : ExchangeRateV1 {
    override fun fromUSD(to: Currency): Double {
        return when (to) {
            Currency.KRW -> 1271.14
            Currency.USD -> 1.0
        }
    }

    override fun fromKRW(to: Currency): Double {
        return when (to) {
            Currency.USD -> 0.00079
            Currency.KRW -> 1.0
        }
    }
}