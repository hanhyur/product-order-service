package kr.hanhyur.productorderservice.payment;

import kr.hanhyur.productorderservice.ApiTest;
import kr.hanhyur.productorderservice.order.OrderSteps;
import kr.hanhyur.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PaymentApiTest extends ApiTest {

    @Test
    void orderProduct() {
        ProductSteps.addProductRequest(ProductSteps.createAddProductRequest());
        OrderSteps.orderProductRequest(OrderSteps.createAddOrderRequest());

        final var request = PaymentSteps.createOrderPaymentRequest();

        final var response = PaymentSteps.orderPaymentRequest(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
