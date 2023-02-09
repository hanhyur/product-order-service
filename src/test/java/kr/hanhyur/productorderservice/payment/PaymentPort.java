package kr.hanhyur.productorderservice.payment;

import kr.hanhyur.productorderservice.order.Order;

interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
