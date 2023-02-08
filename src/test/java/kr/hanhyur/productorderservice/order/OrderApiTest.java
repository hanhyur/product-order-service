package kr.hanhyur.productorderservice.order;

import kr.hanhyur.productorderservice.ApiTest;
import kr.hanhyur.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderApiTest extends ApiTest {

    @Test
    void orderProduct() {
        ProductSteps.addProductRequest(ProductSteps.createAddProductRequest());

        final var request = OrderSteps.createAddOrderRequest();

        var response = OrderSteps.orderProductRequest(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
