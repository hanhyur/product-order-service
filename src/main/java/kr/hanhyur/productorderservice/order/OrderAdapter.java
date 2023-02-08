package kr.hanhyur.productorderservice.order;

import kr.hanhyur.productorderservice.product.Product;
import kr.hanhyur.productorderservice.product.ProductRepository;
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
