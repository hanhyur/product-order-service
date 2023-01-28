package kr.hanhyur.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

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
