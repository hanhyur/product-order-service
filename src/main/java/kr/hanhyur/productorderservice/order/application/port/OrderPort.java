package kr.hanhyur.productorderservice.order.application.port;

import kr.hanhyur.productorderservice.order.domain.Order;
import kr.hanhyur.productorderservice.product.domain.Product;


public interface OrderPort {
    Product getProductById(Long productId);

    void save(final Order order);
}
