package kr.hanhyur.productorderservice.payment;

import kr.hanhyur.productorderservice.order.Order;
import org.springframework.util.Assert;

class Payment {
    private Long id;
    private final Order order;
    private final String cardNumber;

    public Payment(final Order order, final String cardNumber) {
        Assert.notNull(order, "Order is required");
        Assert.hasText(cardNumber, "Card Number is required");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
