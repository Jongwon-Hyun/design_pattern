package adapter

interface ExchangeRateV2 {
    fun getExchangeRate(from: Currency, to: Currency): Double
}