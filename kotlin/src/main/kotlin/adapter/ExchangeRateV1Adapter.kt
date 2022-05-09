package adapter

class ExchangeRateV1Adapter(private val exchangeRateV1: ExchangeRateV1) : ExchangeRateV2 {
    override fun getExchangeRate(from: Currency, to: Currency): Double {
        return when (from) {
            Currency.USD -> exchangeRateV1.fromUSD(to)
            Currency.KRW -> exchangeRateV1.fromKRW(to)
        }
    }
}