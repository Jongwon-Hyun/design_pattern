import adapter.Currency
import adapter.ExchangeRateV1Adapter
import adapter.repository.ExchangeRateV1Repository
import adapter.repository.ExchangeRateV2Repository
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class AdapterTest : FunSpec({
    test("Adapter Run") {
        val exchangeRateV1 = ExchangeRateV1Repository()
        val exchangeRateV2 = ExchangeRateV2Repository()
        val exchangeRateV1Adapter = ExchangeRateV1Adapter(exchangeRateV1)

        val v1USDtoKRW = exchangeRateV1.fromUSD(Currency.KRW)
        v1USDtoKRW shouldBe 1271.14

        val v2USDtoKRW = exchangeRateV2.getExchangeRate(Currency.USD, Currency.KRW)
        v2USDtoKRW shouldBe 1271.14

        val adapterUSDtoKRW = exchangeRateV1Adapter.getExchangeRate(Currency.USD, Currency.KRW)
        adapterUSDtoKRW shouldBe 1271.14


        val v1KRWtoUSD = exchangeRateV1.fromKRW(Currency.USD)
        v1KRWtoUSD shouldBe 0.00079

        val v2KRWtoUSD = exchangeRateV2.getExchangeRate(Currency.KRW, Currency.USD)
        v2KRWtoUSD shouldBe 0.00079

        val adapterKRWtoUSD = exchangeRateV1Adapter.getExchangeRate(Currency.KRW, Currency.USD)
        adapterKRWtoUSD shouldBe 0.00079
    }
})