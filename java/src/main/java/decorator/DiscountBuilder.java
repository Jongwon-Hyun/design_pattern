package decorator;

import decorator.decorator.TenOrderDiscount;
import decorator.decorator.WelcomeDiscount;

public class DiscountBuilder {
    private final Discount discount;

    public Discount getDiscount() {
        return discount;
    }

    private DiscountBuilder(Builder builder) {
        this.discount = builder.discount;
    }

    public static class Builder {
        private Discount discount;
        private WelcomeDiscount welcomeDiscount;
        private TenOrderDiscount tenOrderDiscount;

        public Builder(DiscountType discountType) {
            this.discount = switch(discountType) {
                case STUDENT -> new StudentDiscount();
                case VIP -> new VipDiscount();
            };
        }

        public Builder welcomeDiscount() {
            this.discount = new WelcomeDiscount(this.discount);
            return this;
        }

        public Builder tenOrderDiscount() {
            this.discount = new TenOrderDiscount(this.discount);
            return this;
        }

        public DiscountBuilder build() {
            return new DiscountBuilder(this);
        }
    }
}
