import { Currency, KRW, USD } from "../currency";
import { ExchangeRateV1 } from "../exchange-rate-v1";

export class ExchangeRateV1Repository implements ExchangeRateV1 {
    fromUSD(to: Currency): number {
        switch (to) {
            case KRW: return 1271.14;
            case USD: return 1;
        }
    }

    fromKRW(to: Currency): number {
        switch (to) {
            case USD: return 0.00079;
            case KRW: return 1;
        }
    }
}