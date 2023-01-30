package kr.hanhyur.productorderservice.product;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import kr.hanhyur.productorderservice.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProductApiTest extends ApiTest {

    @Test
    void createProduct() {
        final var request = createAddProductRequest();

        // API REQUEST
        final var response = addProductRequest(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private static ExtractableResponse<Response> addProductRequest(AddProductRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
    }

    private static AddProductRequest createAddProductRequest() {
        final String productName = "Product Name";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;

        return new AddProductRequest(productName, price, discountPolicy);
    }

}
