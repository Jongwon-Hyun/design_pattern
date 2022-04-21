const discountType = {
    student: 'student',
    vip: 'vip'
} as const;

type DiscountType = typeof discountType[keyof typeof discountType];
const STUDENT_DISCOUNT = 'student';
const VIP_DISCOUNT = 'vip'

export {
    DiscountType, STUDENT_DISCOUNT, VIP_DISCOUNT
}