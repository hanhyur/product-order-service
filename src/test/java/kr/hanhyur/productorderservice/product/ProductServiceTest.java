package kr.hanhyur.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProductServiceTest {

    private ProductService productService;
    private StubProductPort productPort = new StubProductPort();

    @BeforeEach
    void setUp() {
        productService = new ProductService(productPort);
    }

    @Test
    void updateProduct() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("Product Update", 2000, DiscountPolicy.NONE);
        final Product product = new Product("Product Name", 1000, DiscountPolicy.NONE);

        productPort.getProduct_will_return = product;

        productService.updateProduct(productId, request);

        assertThat(product.getProductName()).isEqualTo("Product Update");
        assertThat(product.getPrice()).isEqualTo(2000);
    }

    private static class StubProductPort implements ProductPort {
        public Product getProduct_will_return;

        @Override
        public void save(Product product) {

        }

        @Override
        public Product getProduct(Long productId) {
            return getProduct_will_return;
        }
    }
}
