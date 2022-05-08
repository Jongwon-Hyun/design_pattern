package adapter.repository

import adapter.Currency
import adapter.ExchangeRateV2

class ExchangeRateV2Repository : ExchangeRateV2 {
    override fun getExchangeRate(from: Currency, to: Currency): Double {
        return when (from) {
            Currency.USD -> fromUSD(to)
            Currency.KRW -> fromKRW(to)
        }
    }

    private fun fromUSD(to: Currency): Double {
        return when (to) {
            Currency.KRW -> 1271.14
            Currency.USD -> 1.0
        }
    }

    private fun fromKRW(to: Currency): Double {
        return when (to) {
            Currency.USD -> 0.00079
            Currency.KRW -> 1.0
        }
    }
}