const currency = {
    USD: 'USD',
    KRW: 'KRW',
} as const

type Currency = typeof currency[keyof typeof currency];
const USD = currency.USD;
const KRW = currency.KRW;

export {
    Currency, USD, KRW
}