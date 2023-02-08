package kr.hanhyur.productorderservice.order;

import kr.hanhyur.productorderservice.product.Product;


interface OrderPort {
    Product getProductById(Long productId);

    void save(final Order order);
}
