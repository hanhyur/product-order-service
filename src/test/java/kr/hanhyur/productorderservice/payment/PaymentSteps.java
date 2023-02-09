package kr.hanhyur.productorderservice.payment;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class PaymentSteps {
    public static PaymentRequest createOrderPaymentRequest() {
        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";

        return new PaymentRequest(orderId, cardNumber);
    }

    static ExtractableResponse<Response> orderPaymentRequest(PaymentRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/payments")
                .then().log().all().extract();
    }
}