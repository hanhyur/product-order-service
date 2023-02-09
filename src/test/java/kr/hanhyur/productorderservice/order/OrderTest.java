package kr.hanhyur.productorderservice.order;

import kr.hanhyur.productorderservice.order.domain.Order;
import kr.hanhyur.productorderservice.product.domain.DiscountPolicy;
import kr.hanhyur.productorderservice.product.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrderTest {

    @Test
    void getTotalPrice() {
        final Order order = new Order(new Product("ProductName", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2);

        final int totalPrice = order.getTotalPrice();

        assertThat(totalPrice).isEqualTo(2000);
    }

}