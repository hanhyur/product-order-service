package kr.hanhyur.productorderservice.order;

import kr.hanhyur.productorderservice.product.ProductService;
import kr.hanhyur.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;


    @Test
    void orderProduct() {
        productService.addProduct(ProductSteps.createAddProductRequest());

        final AddOrderRequest request = createAddOrderRequest();

        orderService.createOrder(request);
    }

    private static AddOrderRequest createAddOrderRequest() {
        Long productId = 1L;
        int quantity = 2;
        return new AddOrderRequest(productId, quantity);
    }

}
