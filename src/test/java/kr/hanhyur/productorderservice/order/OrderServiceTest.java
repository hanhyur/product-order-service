package kr.hanhyur.productorderservice.order;

import kr.hanhyur.productorderservice.product.DiscountPolicy;
import kr.hanhyur.productorderservice.product.Product;
import kr.hanhyur.productorderservice.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceTest {

    private OrderService orderService;
    private OrderPort orderPort;
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
        orderPort = new OrderPort() {
            @Override
            public Product getProductById(Long productId) {
                return new Product("Product Name", 1000, DiscountPolicy.NONE);
            }

            @Override
            public void save(Order order) {
                orderRepository.save(order);
            }
        };
        orderService = new OrderService(orderPort);
    }

    @Test
    void orderProduct() {
        Long productId = 1L;
        int quantity = 2;
        final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);

        orderService.createOrder(request);

    }

    private record CreateOrderRequest(Long productId, int quantity) {
        private CreateOrderRequest {
            Assert.notNull(productId, "Product Id is required");
            Assert.isTrue(quantity > 0, "Quantity must be bigger than 0");

        }
    }

    private class OrderService {
        private final OrderPort orderPort;

        private OrderService(OrderPort orderPort) {
            this.orderPort = orderPort;
        }

        public void createOrder(CreateOrderRequest request) {
            final Product product = orderPort.getProductById(request.productId());

            final Order order = new Order(product, request.quantity());

            orderPort.save(order);
        }
    }

    private class OrderAdapter implements OrderPort {
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

    private class Order {
        private Long id;
        private final Product product;
        private final int quantity;

        public Order(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
            Assert.notNull(product, "Product is required");
            Assert.isTrue(quantity > 0, "Quantity must be bigger than 0");
        }

        public void assignId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    private class OrderRepository {
        private final Map<Long, Order> persistence = new HashMap<>();
        private Long sequence = 0L;

        public void save(Order order) {
            order.assignId(++sequence);
            persistence.put(order.getId(), order);
        }
    }

    private interface OrderPort {
        Product getProductById(Long productId);

        void save(final Order order);
    }
}
