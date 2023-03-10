package kr.hanhyur.productorderservice.payment.application.service;

import org.springframework.util.Assert;

record PaymentRequest(Long orderId, String cardNumber) {
    PaymentRequest {
        Assert.notNull(orderId, "Id is required");
        Assert.hasText(cardNumber, "Card Number is required");
    }
}
