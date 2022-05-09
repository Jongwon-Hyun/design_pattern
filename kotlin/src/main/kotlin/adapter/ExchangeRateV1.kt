package adapter

interface ExchangeRateV1 {
    fun fromUSD(to: Currency): Double
    fun fromKRW(to: Currency): Double
}