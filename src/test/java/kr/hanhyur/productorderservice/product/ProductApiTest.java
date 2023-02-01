package kr.hanhyur.productorderservice.product;

import kr.hanhyur.productorderservice.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProductApiTest extends ApiTest {

    @Test
    void createProduct() {
        final var request = ProductSteps.createAddProductRequest();

        // API REQUEST
        final var response = ProductSteps.addProductRequest(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
