const DEFAULT_FEE = 0.03
const PARTNERSHIP_FEE = 0.01

interface Fee {
    calculate(amount: number): number
}

export {
    DEFAULT_FEE, 
    PARTNERSHIP_FEE,
    Fee,
}