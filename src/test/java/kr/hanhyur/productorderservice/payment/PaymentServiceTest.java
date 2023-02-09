package kr.hanhyur.productorderservice.payment;

import kr.hanhyur.productorderservice.order.OrderService;
import kr.hanhyur.productorderservice.order.OrderSteps;
import kr.hanhyur.productorderservice.product.ProductService;
import kr.hanhyur.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Test
    void orderProduct() {
        productService.addProduct(ProductSteps.createAddProductRequest());
        orderService.createOrder(OrderSteps.createAddOrderRequest());
        final PaymentRequest request = PaymentSteps.createOrderPaymentRequest();

        paymentService.payment(request);
    }

}
