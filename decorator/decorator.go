package decorator

const (
	WelcomeDiscountRate     = 0.01
	WelcomeDiscountHistory  = "웰컴 할인"
	TenOrderDiscountRate    = 0.02
	TenOrderDiscountHistory = "10번 주문 할인"
)

type welcomeDiscount struct {
	discount Discount
}

func NewWelcomeDiscount(discount Discount) *welcomeDiscount {
	return &welcomeDiscount{discount: discount}
}

func (w *welcomeDiscount) amountAfterDiscount(amount float64) float64 {
	return w.discount.amountAfterDiscount(amount) * WelcomeDiscountRate
}

func (w *welcomeDiscount) history() string {
	return w.discount.history() + " " + WelcomeDiscountHistory
}

type tenOrderDiscount struct {
	discount Discount
}

func NewTenOrderDiscount(discount Discount) *tenOrderDiscount {
	return &tenOrderDiscount{discount: discount}
}

func (t *tenOrderDiscount) amountAfterDiscount(amount float64) float64 {
	return t.discount.amountAfterDiscount(amount) * TenOrderDiscountRate
}

func (t *tenOrderDiscount) history() string {
	return t.discount.history() + " " + TenOrderDiscountHistory
}
