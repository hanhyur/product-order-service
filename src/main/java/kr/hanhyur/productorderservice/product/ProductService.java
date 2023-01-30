package kr.hanhyur.productorderservice.product;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
class ProductService {
    private final ProductPort productPort;

    ProductService(final ProductPort productPort) {
        this.productPort = productPort;
    }

    @Transactional
    public void addProduct(AddProductRequest request) {
        final Product product = new Product(request.productName(), request.price(), request.discountPolicy());

        productPort.save(product);
    }
}
