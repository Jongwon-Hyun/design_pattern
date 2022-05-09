package adapter

import "errors"

type ExchangeRateV1 interface {
	FromUSD(to Currency) (float64, error)
	FromKRW(to Currency) (float64, error)
}

type exchangeRateV1Repository struct{}

func NewExchangeRateV1Repository() ExchangeRateV1 {
	return &exchangeRateV1Repository{}
}

func (e exchangeRateV1Repository) FromUSD(to Currency) (float64, error) {
	switch to.String() {
	case KRW.String():
		return 1271.14, nil
	case USD.String():
		return 1, nil
	}

	return 0, errors.New("invalid currency")
}

func (e exchangeRateV1Repository) FromKRW(to Currency) (float64, error) {
	switch to.String() {
	case USD.String():
		return 0.00079, nil
	case KRW.String():
		return 1, nil
	}

	return 0, errors.New("invalid currency")
}

type ExchangeRateV2 interface {
	GetExchangeRate(from Currency, to Currency) (float64, error)
}

type exchangeRateV2Repository struct{}

func NewExchangeRateV2Repository() ExchangeRateV2 {
	return &exchangeRateV2Repository{}
}

func (e exchangeRateV2Repository) GetExchangeRate(from Currency, to Currency) (float64, error) {
	switch from.String() {
	case USD.String():
		return e.fromUSD(to)
	case KRW.String():
		return e.fromKRW(to)
	}

	return 0, errors.New("invalid currency")
}

func (e exchangeRateV2Repository) fromUSD(to Currency) (float64, error) {
	switch to.String() {
	case KRW.String():
		return 1271.14, nil
	case USD.String():
		return 1, nil
	}

	return 0, errors.New("invalid currency")
}

func (e exchangeRateV2Repository) fromKRW(to Currency) (float64, error) {
	switch to.String() {
	case USD.String():
		return 0.00079, nil
	case KRW.String():
		return 1, nil
	}

	return 0, errors.New("invalid currency")
}
