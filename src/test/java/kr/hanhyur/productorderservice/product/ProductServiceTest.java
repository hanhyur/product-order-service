package kr.hanhyur.productorderservice.product;

import kr.hanhyur.productorderservice.product.application.service.GetProductResponse;
import kr.hanhyur.productorderservice.product.application.service.ProductService;
import kr.hanhyur.productorderservice.product.application.service.UpdateProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void updateProduct() {
        productService.addProduct(ProductSteps.createAddProductRequest());

        final Long productId = 1L;
        final UpdateProductRequest request = ProductSteps.createUpdateProductRequest();
        
        productService.updateProduct(productId, request);

        ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        GetProductResponse productResponse = response.getBody();

        assertThat(productResponse.productName()).isEqualTo("Product Update");
        assertThat(productResponse.price()).isEqualTo(2000);
    }

}
