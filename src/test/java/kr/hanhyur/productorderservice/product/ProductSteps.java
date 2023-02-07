package kr.hanhyur.productorderservice.product;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class ProductSteps {
    public static ExtractableResponse<Response> addProductRequest(AddProductRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
    }

    public static AddProductRequest createAddProductRequest() {
        final String productName = "Product Name";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;

        return new AddProductRequest(productName, price, discountPolicy);
    }

    public static ExtractableResponse<Response> getProduct(Long productId) {
        return RestAssured.given().log().all()
                .when()
                .get("/products/{productId}", productId)
                .then().log().all()
                .extract();
    }

    public static UpdateProductRequest createUpdateProductRequest() {
        return new UpdateProductRequest("Product Update", 2000, DiscountPolicy.NONE);
    }

    public static ExtractableResponse<Response> updateProductRequest(long productId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createUpdateProductRequest())
                .when()
                .patch("/products/{productId}", productId)
                .then().log().all()
                .extract();
    }
}