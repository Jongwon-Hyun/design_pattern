import { Currency } from "./currency";

export interface ExchangeRateV2 {
    getExchangeRate(from: Currency, to: Currency): number
}