package kr.hanhyur.productorderservice.order.adapter;

import kr.hanhyur.productorderservice.order.application.port.OrderPort;
import kr.hanhyur.productorderservice.order.domain.Order;
import kr.hanhyur.productorderservice.product.adapter.ProductRepository;
import kr.hanhyur.productorderservice.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
class OrderAdapter implements OrderPort {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private OrderAdapter(final ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product does not exist"));
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
