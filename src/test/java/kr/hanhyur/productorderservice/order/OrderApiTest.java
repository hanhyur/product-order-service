package kr.hanhyur.productorderservice.order;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import kr.hanhyur.productorderservice.ApiTest;
import kr.hanhyur.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderApiTest extends ApiTest {

    @Test
    void orderProduct() {
        ProductSteps.addProductRequest(ProductSteps.createAddProductRequest());

        final AddOrderRequest request = createAddOrderRequest();

        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/orders")
                .then()
                .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private static AddOrderRequest createAddOrderRequest() {
        Long productId = 1L;
        int quantity = 2;
        return new AddOrderRequest(productId, quantity);
    }

}
