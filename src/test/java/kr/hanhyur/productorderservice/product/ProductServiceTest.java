package kr.hanhyur.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;

    @BeforeEach
    void setUp() {
        productPort = Mockito.mock(ProductPort.class);
        productService = new ProductService(productPort);
    }

    @Test
    void updateProduct() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("Product Update", 2000, DiscountPolicy.NONE);
        final Product product = new Product("Product Name", 1000, DiscountPolicy.NONE);

        Mockito.when(productPort.getProduct(productId)).thenReturn(product);

        productService.updateProduct(productId, request);

        assertThat(product.getProductName()).isEqualTo("Product Update");
        assertThat(product.getPrice()).isEqualTo(2000);
    }

//    private static class StubProductPort implements ProductPort {
//        public Product getProduct_will_return;
//
//        @Override
//        public void save(Product product) {
//
//        }
//
//        @Override
//        public Product getProduct(Long productId) {
//            return getProduct_will_return;
//        }
//    }
}
