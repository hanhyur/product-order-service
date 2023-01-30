package kr.hanhyur.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void createProduct() {
        final AddProductRequest request = createAddProductRequest();

        productService.addProduct(request);
    }

    private static AddProductRequest createAddProductRequest() {
        final String productName = "Product Name";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;

        return new AddProductRequest(productName, price, discountPolicy);
    }

}
