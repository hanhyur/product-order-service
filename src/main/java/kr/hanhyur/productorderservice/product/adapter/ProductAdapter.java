package kr.hanhyur.productorderservice.product.adapter;

import kr.hanhyur.productorderservice.product.application.port.ProductPort;
import kr.hanhyur.productorderservice.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
class ProductAdapter implements ProductPort {
    private final ProductRepository productRepository;

    ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product does not exist"));
    }

}
