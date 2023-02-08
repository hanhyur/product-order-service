package kr.hanhyur.productorderservice.order;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class OrderSteps {
    public static ExtractableResponse<Response> orderProductRequest(AddOrderRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/orders")
                .then()
                .log().all().extract();
    }

    public static AddOrderRequest createAddOrderRequest() {
        Long productId = 1L;
        int quantity = 2;
        return new AddOrderRequest(productId, quantity);
    }
}
