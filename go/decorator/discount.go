package decorator

const (
	StudentDiscountRate    = 0.03
	StudentDiscountHistory = "학생 할인"
	VipDiscountRate        = 0.05
	VipDiscountHistory     = "VIP 할인"
)

type Discount interface {
	amountAfterDiscount(amount float64) float64
	history() string
}

type studentDiscount struct {
}

func NewStudentDiscount() Discount {
	return &studentDiscount{}
}

func (s *studentDiscount) amountAfterDiscount(amount float64) float64 {
	return amount * StudentDiscountRate
}

func (s *studentDiscount) history() string {
	return StudentDiscountHistory
}

type vipDiscount struct {
}

func NewVipDiscount() Discount {
	return &vipDiscount{}
}

func (v *vipDiscount) amountAfterDiscount(amount float64) float64 {
	return amount * VipDiscountRate
}

func (v *vipDiscount) history() string {
	return VipDiscountHistory
}
