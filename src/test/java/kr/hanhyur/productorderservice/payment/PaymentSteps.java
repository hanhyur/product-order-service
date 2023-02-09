package kr.hanhyur.productorderservice.payment;

public class PaymentSteps {
    public static PaymentRequest createOrderPaymentRequest() {
        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";

        return new PaymentRequest(orderId, cardNumber);
    }
}