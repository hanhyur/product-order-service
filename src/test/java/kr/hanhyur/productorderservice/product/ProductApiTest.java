package kr.hanhyur.productorderservice.product;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
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

    @Test
    void getProduct() {
        ProductSteps.addProductRequest(ProductSteps.createAddProductRequest());
        Long productId = 1L;

        ExtractableResponse<Response> response = ProductSteps.getProduct(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("Product Name");
    }

}
