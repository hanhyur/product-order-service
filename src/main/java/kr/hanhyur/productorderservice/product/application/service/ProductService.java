package kr.hanhyur.productorderservice.product.application.service;

import jakarta.transaction.Transactional;
import kr.hanhyur.productorderservice.product.application.port.ProductPort;
import kr.hanhyur.productorderservice.product.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public
class ProductService {
    private final ProductPort productPort;

    ProductService(final ProductPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> addProduct(@RequestBody AddProductRequest request) {
        final Product product = new Product(request.productName(), request.price(), request.discountPolicy());

        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable final Long productId) {
        final Product product = productPort.getProduct(productId);

        GetProductResponse response = new GetProductResponse(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                product.getDiscountPolicy());

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{productId}")
    @Transactional
    public ResponseEntity<Void> updateProduct(@PathVariable Long productId,
                                              @RequestBody UpdateProductRequest request) {
        final Product product = productPort.getProduct(productId);

        product.update(request.productName(), request.price(), request.discountPolicy());

        productPort.save(product);

        return ResponseEntity.ok().build();
    }
}
