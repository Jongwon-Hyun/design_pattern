import { Currency, USD, KRW } from "./currency";
import { ExchangeRateV1 } from "./exchange-rate-v1";
import { ExchangeRateV2 } from "./exchange-rate-v2";

export class ExchangeRateV1Adapter implements ExchangeRateV2 {
    constructor(private readonly exchangeRateV1: ExchangeRateV1) {}

    getExchangeRate(from: Currency, to: Currency): number {
        switch (from) {
            case USD: return this.exchangeRateV1.fromUSD(to);
            case KRW: return this.exchangeRateV1.fromKRW(to);
        }
    }
}