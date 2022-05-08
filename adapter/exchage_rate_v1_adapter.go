package adapter

import "errors"

type exchangeRateV1Adapter struct {
	exchangeRateV1 ExchangeRateV1
}

func NewExchangeRateV1Adapter(exchangeRateV1 ExchangeRateV1) ExchangeRateV2 {
	return &exchangeRateV1Adapter{exchangeRateV1: exchangeRateV1}
}

func (e exchangeRateV1Adapter) GetExchangeRate(from Currency, to Currency) (float64, error) {
	switch from.String() {
	case USD.String():
		return e.exchangeRateV1.FromUSD(to)
	case KRW.String():
		return e.exchangeRateV1.FromKRW(to)
	}

	return 0, errors.New("invalid currency")
}
