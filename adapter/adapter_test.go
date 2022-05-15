package adapter

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestAdapter(t *testing.T) {
	t.Run("Test Adapter", func(t *testing.T) {
		exchangeRateV1 := NewExchangeRateV1Repository()
		exchangeRateV2 := NewExchangeRateV2Repository()
		exchangeRateV1Adapter := NewExchangeRateV1Adapter(exchangeRateV1)

		v1USDToKRW, err := exchangeRateV1.FromUSD(KRW)
		if err != nil {
			t.Error(err)
		}
		assert.Equal(t, 1271.14, v1USDToKRW)

		v2USDToKRW, err := exchangeRateV2.GetExchangeRate(USD, KRW)
		if err != nil {
			t.Error(err)
		}
		assert.Equal(t, 1271.14, v2USDToKRW)

		adapterUSDToKRW, err := exchangeRateV1Adapter.GetExchangeRate(USD, KRW)
		if err != nil {
			t.Error(err)
		}
		assert.Equal(t, 1271.14, adapterUSDToKRW)

		v1KRWToUSD, err := exchangeRateV1.FromKRW(USD)
		if err != nil {
			t.Error(err)
		}
		assert.Equal(t, 0.00079, v1KRWToUSD)

		v2KRWToUSD, err := exchangeRateV2.GetExchangeRate(KRW, USD)
		if err != nil {
			t.Error(err)
		}
		assert.Equal(t, 0.00079, v2KRWToUSD)

		adapterKRWToUSD, err := exchangeRateV1Adapter.GetExchangeRate(KRW, USD)
		if err != nil {
			t.Error(err)
		}
		assert.Equal(t, 0.00079, adapterKRWToUSD)
	})
}
