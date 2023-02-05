package kr.hanhyur.productorderservice.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProductTest {

    @Test
    void update() {
        final Product product = new Product("Test Product", 1000, DiscountPolicy.NONE);

        product.update("Test Update", 2000, DiscountPolicy.NONE);

        assertThat(product.getProductName()).isEqualTo("Test Update");
        assertThat(product.getPrice()).isEqualTo(2000);
    }
}