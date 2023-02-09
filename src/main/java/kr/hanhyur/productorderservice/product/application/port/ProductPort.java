package kr.hanhyur.productorderservice.product.application.port;

import kr.hanhyur.productorderservice.product.domain.Product;

public interface ProductPort {
    void save(Product product);

    Product getProduct(Long productId);
}
