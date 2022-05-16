import { TenOrderDiscount } from "./decorator/ten-order-discount";
import { WelcomeDiscount } from "./decorator/welcome-discount";
import { DiscountBuilder } from "./discount-builder";
import { STUDENT_DISCOUNT, VIP_DISCOUNT } from "./discount-type";
import { StudentDiscount } from "./student-discount";
import { VipDiscount } from "./vip-discount";

test('Test Decorator', () => {
    const amount = 1000;

    const student = new DiscountBuilder(STUDENT_DISCOUNT);
    const studentDiscount = student.getDiscount();
    const studentAmount = studentDiscount.amountAfterDiscount(amount);
    const studentHistory = studentDiscount.history();
    expect(studentAmount).toEqual(amount * StudentDiscount.RATE);
    expect(studentHistory).toEqual(StudentDiscount.HISTORY);


    var vip = new DiscountBuilder(VIP_DISCOUNT);
    const vipDiscount = vip.getDiscount();
    const vipAmount = vipDiscount.amountAfterDiscount(amount);
    const vipHistory = vipDiscount.history();
    expect(vipAmount).toEqual(amount * VipDiscount.RATE);
    expect(vipHistory).toEqual(VipDiscount.HISTORY);


    var studentWithWelcome = new DiscountBuilder(STUDENT_DISCOUNT).welcomeDiscount();
    const studentWithWelcomeDiscount = studentWithWelcome.getDiscount();
    const studentWithWelcomeAmount = studentWithWelcomeDiscount.amountAfterDiscount(amount);
    const studentWithWelcomeHistory = studentWithWelcomeDiscount.history();
    expect(studentWithWelcomeAmount).toEqual(amount * StudentDiscount.RATE * WelcomeDiscount.RATE);
    expect(studentWithWelcomeHistory).toEqual(`${StudentDiscount.HISTORY} ${WelcomeDiscount.HISTORY}`);


    var studentWithWelcomeAndTenOrder = new DiscountBuilder(STUDENT_DISCOUNT).welcomeDiscount().tenOrderDiscount();
    const studentWithWelcomeAndTenOrderDiscount = studentWithWelcomeAndTenOrder.getDiscount();
    const studentWithWelcomeAndTenOrderAmount = studentWithWelcomeAndTenOrderDiscount.amountAfterDiscount(amount);
    const studentWithWelcomeAndTenOrderHistory = studentWithWelcomeAndTenOrderDiscount.history();
    expect(studentWithWelcomeAndTenOrderAmount)
        .toEqual(amount * StudentDiscount.RATE * WelcomeDiscount.RATE * TenOrderDiscount.RATE);
    expect(studentWithWelcomeAndTenOrderHistory)
        .toEqual(`${StudentDiscount.HISTORY} ${WelcomeDiscount.HISTORY} ${TenOrderDiscount.HISTORY}`);


    var vipWithTenOrder = new DiscountBuilder(VIP_DISCOUNT).tenOrderDiscount();
    const vipWithTenOrderDiscount = vipWithTenOrder.getDiscount();
    const vipWithTenOrderAmount = vipWithTenOrderDiscount.amountAfterDiscount(amount);
    const vipWithTenOrderHistory = vipWithTenOrderDiscount.history();
    expect(vipWithTenOrderAmount).toEqual(amount * VipDiscount.RATE * TenOrderDiscount.RATE);
    expect(vipWithTenOrderHistory).toEqual(`${VipDiscount.HISTORY} ${TenOrderDiscount.HISTORY}`);


    var vipWithTenOrderAndWelcome = new DiscountBuilder(VIP_DISCOUNT).tenOrderDiscount().welcomeDiscount();
    const vipWithTenOrderAndWelcomeDiscount = vipWithTenOrderAndWelcome.getDiscount();
    const vipWithTenOrderAndWelcomeAmount = vipWithTenOrderAndWelcomeDiscount.amountAfterDiscount(amount);
    const vipWithTenOrderAndWelcomeHistory = vipWithTenOrderAndWelcomeDiscount.history();
    expect(vipWithTenOrderAndWelcomeAmount)
        .toEqual(amount * VipDiscount.RATE * TenOrderDiscount.RATE * WelcomeDiscount.RATE);
    expect(vipWithTenOrderAndWelcomeHistory)
        .toEqual(`${VipDiscount.HISTORY} ${TenOrderDiscount.HISTORY} ${WelcomeDiscount.HISTORY}`);
});