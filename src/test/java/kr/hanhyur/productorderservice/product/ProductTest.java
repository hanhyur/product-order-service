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

    @Test
    void none_discounted_product() {
        final Product product = new Product("Test Product", 1000, DiscountPolicy.NONE);

        final int discountPrice = product.getDiscountedPrice();

        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    void fix_1000_discounted_product() {
        final Product product = new Product("Test Product", 1000, DiscountPolicy.FIX_1000_AMOUNT);

        final int discountPrice = product.getDiscountedPrice();

        assertThat(discountPrice).isEqualTo(0);
    }

}