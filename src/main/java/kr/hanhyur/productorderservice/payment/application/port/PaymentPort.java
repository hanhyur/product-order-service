package kr.hanhyur.productorderservice.payment.application.port;

import kr.hanhyur.productorderservice.order.domain.Order;
import kr.hanhyur.productorderservice.payment.domain.Payment;

public interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
