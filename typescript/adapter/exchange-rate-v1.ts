import { Currency } from "./currency";

export interface ExchangeRateV1 {
    fromUSD(to: Currency): number
    fromKRW(to: Currency): number
}