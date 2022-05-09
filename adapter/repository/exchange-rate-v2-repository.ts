import { Currency, KRW, USD } from "../currency";
import { ExchangeRateV2 } from "../exchange-rate-v2";

export class ExchangeRateV2Repository implements ExchangeRateV2 {
    getExchangeRate(from: Currency, to: Currency): number {
        switch (from) {
            case USD: return this.fromUSD(to);
            case KRW: return this.fromKRW(to);
        }
    }

    private fromUSD(to: Currency): number {
        switch (to) {
            case KRW: return 1271.14;
            case USD: return 1;
        }
    }

    private fromKRW(to: Currency): number {
        switch (to) {
            case USD: return 0.00079;
            case KRW: return 1;
        }
    }

}