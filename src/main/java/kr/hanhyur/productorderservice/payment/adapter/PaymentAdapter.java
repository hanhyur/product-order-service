package kr.hanhyur.productorderservice.payment.adapter;

import kr.hanhyur.productorderservice.order.domain.Order;
import kr.hanhyur.productorderservice.order.adapter.OrderRepository;
import kr.hanhyur.productorderservice.payment.application.port.PaymentPort;
import kr.hanhyur.productorderservice.payment.domain.Payment;
import org.springframework.stereotype.Component;

@Component
class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order does not exist"));
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.excute(totalPrice, cardNumber);
    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }
}
