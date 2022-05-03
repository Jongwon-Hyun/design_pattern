import decorator.DiscountBuilder;
import decorator.DiscountType;
import decorator.StudentDiscount;
import decorator.VipDiscount;
import decorator.decorator.TenOrderDiscount;
import decorator.decorator.WelcomeDiscount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoratorTest {

    @Test
    void DecoratorRun() {
        final var amount = 1000;

        final var student = new DiscountBuilder.Builder(DiscountType.STUDENT).build();
        final var studentDiscount = student.getDiscount();
        final var studentAmount = studentDiscount.amountAfterDiscount(amount);
        final var studentHistory = studentDiscount.history();
        assertEquals(amount * StudentDiscount.RATE, studentAmount);
        assertEquals(StudentDiscount.HISTORY, studentHistory);


        final var vip = new DiscountBuilder.Builder(DiscountType.VIP).build();
        final var vipDiscount = vip.getDiscount();
        final var vipAmount = vipDiscount.amountAfterDiscount(amount);
        final var vipHistory = vipDiscount.history();
        assertEquals(amount * VipDiscount.RATE, vipAmount);
        assertEquals(VipDiscount.HISTORY, vipHistory);


        final var studentWithWelcome = new DiscountBuilder.Builder(DiscountType.STUDENT)
                .welcomeDiscount()
                .build();
        final var studentWithWelcomeDiscount = studentWithWelcome.getDiscount();
        final var studentWithWelcomeAmount = studentWithWelcomeDiscount.amountAfterDiscount(amount);
        final var studentWithWelcomeHistory = studentWithWelcomeDiscount.history();
        assertEquals(amount * StudentDiscount.RATE * WelcomeDiscount.RATE, studentWithWelcomeAmount);
        assertEquals(StudentDiscount.HISTORY + " " + WelcomeDiscount.HISTORY, studentWithWelcomeHistory);


        final var studentWithWelcomeAndTenOrder = new DiscountBuilder.Builder(DiscountType.STUDENT)
                .welcomeDiscount()
                .tenOrderDiscount()
                .build();
        final var studentWithWelcomeAndTenOrderDiscount = studentWithWelcomeAndTenOrder.getDiscount();
        final var studentWithWelcomeAndTenOrderAmount = studentWithWelcomeAndTenOrderDiscount.amountAfterDiscount(amount);
        final var studentWithWelcomeAndTenOrderHistory = studentWithWelcomeAndTenOrderDiscount.history();
        assertEquals(amount * StudentDiscount.RATE * WelcomeDiscount.RATE * TenOrderDiscount.RATE,
                studentWithWelcomeAndTenOrderAmount);
        assertEquals(StudentDiscount.HISTORY + " " + WelcomeDiscount.HISTORY + " " + TenOrderDiscount.HISTORY,
                studentWithWelcomeAndTenOrderHistory);


        final var vipWithTenOrder = new DiscountBuilder.Builder(DiscountType.VIP)
                .tenOrderDiscount()
                .build();
        final var vipWithTenOrderDiscount = vipWithTenOrder.getDiscount();
        final var vipWithTenOrderAmount = vipWithTenOrderDiscount.amountAfterDiscount(amount);
        final var vipWithTenOrderHistory = vipWithTenOrderDiscount.history();
        assertEquals(amount * VipDiscount.RATE * TenOrderDiscount.RATE, vipWithTenOrderAmount);
        assertEquals(VipDiscount.HISTORY + " " + TenOrderDiscount.HISTORY, vipWithTenOrderHistory);


        final var vipWithTenOrderAndWelcome = new DiscountBuilder.Builder(DiscountType.VIP)
                .tenOrderDiscount()
                .welcomeDiscount()
                .build();
        final var vipWithTenOrderAndWelcomeDiscount = vipWithTenOrderAndWelcome.getDiscount();
        final var vipWithTenOrderAndWelcomeAmount = vipWithTenOrderAndWelcomeDiscount.amountAfterDiscount(amount);
        final var vipWithTenOrderAndWelcomeHistory = vipWithTenOrderAndWelcomeDiscount.history();
        assertEquals(amount * VipDiscount.RATE * TenOrderDiscount.RATE * WelcomeDiscount.RATE,
                vipWithTenOrderAndWelcomeAmount);
        assertEquals(VipDiscount.HISTORY + " " + TenOrderDiscount.HISTORY + " " + WelcomeDiscount.HISTORY,
                vipWithTenOrderAndWelcomeHistory);
    }
}
