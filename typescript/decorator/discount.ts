export interface Discount {
    amountAfterDiscount(amount: number): number
    history(): string
}