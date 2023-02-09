package kr.hanhyur.productorderservice.product;

import kr.hanhyur.productorderservice.ApiTest;
import kr.hanhyur.productorderservice.product.adapter.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProductApiTest extends ApiTest {

    @Autowired
    ProductRepository productRepository;

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

        final var response = ProductSteps.getProduct(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("Product Name");
    }

    @Test
    void updateProduct() {
        ProductSteps.addProductRequest(ProductSteps.createAddProductRequest());

        final long productId = 1L;

        final var response = ProductSteps.updateProductRequest(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(productRepository.findById(1L).get().getProductName()).isEqualTo("Product Update");
    }

}
