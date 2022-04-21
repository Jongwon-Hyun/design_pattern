import { TenOrderDiscount } from "./decorator/ten-order-discount";
import { WelcomeDiscount } from "./decorator/welcome-discount";
import { Discount } from "./discount";
import { DiscountType, STUDENT_DISCOUNT, VIP_DISCOUNT } from "./discount-type";
import { StudentDiscount } from "./student-discount";
import { VipDiscount } from "./vip-discount";

export class DiscountBuilder {
    private discount: Discount

    constructor(discountType: DiscountType) {
        switch(discountType) {
            case STUDENT_DISCOUNT: {
                this.discount = new StudentDiscount();
                return;
            }
            case VIP_DISCOUNT: {
                this.discount = new VipDiscount();
            }
        }
    }

    welcomeDiscount(): DiscountBuilder {
        this.discount = new WelcomeDiscount(this.discount);
        return this;
    }

    tenOrderDiscount(): DiscountBuilder {
        this.discount = new TenOrderDiscount(this.discount);
        return this;
    }

    getDiscount(): Discount {
        return this.discount;
    }
}