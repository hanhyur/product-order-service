package kr.hanhyur.productorderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void getProducts() {
        // ADD PRODUCTS
        productService.addProduct(ProductSteps.createAddProductRequest());
        final long productId = 1L;

        // GET PRODUCTS
        final GetProductResponse response = productService.getProduct(productId);

        // VALIDATION
        assertThat(response).isNotNull();
    }

}
