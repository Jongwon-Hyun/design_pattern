package decorator

type DiscountType struct {
	slug string
}

var (
	StudentDiscount = DiscountType{"student_discount"}
	VipDiscount     = DiscountType{"vip_discount"}
)

func (d DiscountType) String() string {
	return d.slug
}
