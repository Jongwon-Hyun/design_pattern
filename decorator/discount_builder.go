package decorator

type DiscountBuilder struct {
	discount Discount
}

func NewDiscountBuilder(discountType DiscountType) *DiscountBuilder {
	switch discountType.String() {
	case StudentDiscount.String():
		return &DiscountBuilder{discount: NewStudentDiscount()}
	case VipDiscount.String():
		return &DiscountBuilder{discount: NewVipDiscount()}
	}

	return nil
}

func (d *DiscountBuilder) WelcomeDiscount() *DiscountBuilder {
	d.discount = NewWelcomeDiscount(d.discount)
	return d
}

func (d *DiscountBuilder) TenOrderDiscount() *DiscountBuilder {
	d.discount = NewTenOrderDiscount(d.discount)
	return d
}

func (d DiscountBuilder) GetDiscount() Discount {
	return d.discount
}
