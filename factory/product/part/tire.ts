const tire = {
    normal: 'normal',
    offload: 'offload',
} as const

type Tire = typeof tire[keyof typeof tire]
const NORMAL_TIRE = tire.normal
const OFFLOAD_TIRE = tire.offload

export {
    Tire, NORMAL_TIRE, OFFLOAD_TIRE
}