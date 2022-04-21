package decorator

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestDecorate(t *testing.T) {
	t.Run("Decorate run", func(t *testing.T) {
		var amount float64 = 1000

		student := NewDiscountBuilder(StudentDiscount)
		if student == nil {
			t.Error("not exist discount")
		}
		studentDiscount := student.GetDiscount()
		studentAmount := studentDiscount.amountAfterDiscount(amount)
		studentHistory := studentDiscount.history()
		assert.Equal(t, amount*StudentDiscountRate, studentAmount)
		assert.Equal(t, StudentDiscountHistory, studentHistory)

		vip := NewDiscountBuilder(VipDiscount)
		if vip == nil {
			t.Error("not exist discount")
		}
		vipDiscount := vip.GetDiscount()
		vipAmount := vipDiscount.amountAfterDiscount(amount)
		vipHistory := vipDiscount.history()
		assert.Equal(t, amount*VipDiscountRate, vipAmount)
		assert.Equal(t, VipDiscountHistory, vipHistory)

		studentWithWelcome := NewDiscountBuilder(StudentDiscount)
		if studentWithWelcome == nil {
			t.Error("not exist discount")
		}
		studentWithWelcome = studentWithWelcome.WelcomeDiscount()
		studentWithWelcomeDiscount := studentWithWelcome.GetDiscount()
		studentWithWelcomeAmount := studentWithWelcomeDiscount.amountAfterDiscount(amount)
		studentWithWelcomeHistory := studentWithWelcomeDiscount.history()
		assert.Equal(t, amount*StudentDiscountRate*WelcomeDiscountRate, studentWithWelcomeAmount)
		assert.Equal(t, StudentDiscountHistory+" "+WelcomeDiscountHistory, studentWithWelcomeHistory)

		studentWithWelcomeAndTenOrder := NewDiscountBuilder(StudentDiscount)
		if studentWithWelcomeAndTenOrder == nil {
			t.Error("not exist discount")
		}
		studentWithWelcomeAndTenOrder = studentWithWelcomeAndTenOrder.WelcomeDiscount().TenOrderDiscount()
		studentWithWelcomeAndTenOrderDiscount := studentWithWelcomeAndTenOrder.GetDiscount()
		studentWithWelcomeAndTenOrderAmount := studentWithWelcomeAndTenOrderDiscount.amountAfterDiscount(amount)
		studentWithWelcomeAndTenOrderHistory := studentWithWelcomeAndTenOrderDiscount.history()
		assert.Equal(t, amount*StudentDiscountRate*WelcomeDiscountRate*TenOrderDiscountRate,
			studentWithWelcomeAndTenOrderAmount)
		assert.Equal(t, StudentDiscountHistory+" "+WelcomeDiscountHistory+" "+TenOrderDiscountHistory,
			studentWithWelcomeAndTenOrderHistory)

		vipWithTenOrder := NewDiscountBuilder(VipDiscount)
		if vipWithTenOrder == nil {
			t.Error("not exist discount")
		}
		vipWithTenOrder = vipWithTenOrder.TenOrderDiscount()
		vipWithTenOrderDiscount := vipWithTenOrder.GetDiscount()
		vipWithTenOrderAmount := vipWithTenOrderDiscount.amountAfterDiscount(amount)
		vipWithTenOrderHistory := vipWithTenOrderDiscount.history()
		assert.Equal(t, amount*VipDiscountRate*TenOrderDiscountRate, vipWithTenOrderAmount)
		assert.Equal(t, VipDiscountHistory+" "+TenOrderDiscountHistory, vipWithTenOrderHistory)

		vipWithTenOrderAndWelcome := NewDiscountBuilder(VipDiscount)
		if vipWithTenOrderAndWelcome == nil {
			t.Error("not exist discount")
		}
		vipWithTenOrderAndWelcome = vipWithTenOrderAndWelcome.TenOrderDiscount().WelcomeDiscount()
		vipWithTenOrderAndWelcomeDiscount := vipWithTenOrderAndWelcome.GetDiscount()
		vipWithTenOrderAndWelcomeAmount := vipWithTenOrderAndWelcomeDiscount.amountAfterDiscount(amount)
		vipWithTenOrderAndWelcomeHistory := vipWithTenOrderAndWelcomeDiscount.history()
		assert.Equal(t, amount*VipDiscountRate*TenOrderDiscountRate*WelcomeDiscountRate,
			vipWithTenOrderAndWelcomeAmount)
		assert.Equal(t, VipDiscountHistory+" "+TenOrderDiscountHistory+" "+WelcomeDiscountHistory,
			vipWithTenOrderAndWelcomeHistory)
	})
}
