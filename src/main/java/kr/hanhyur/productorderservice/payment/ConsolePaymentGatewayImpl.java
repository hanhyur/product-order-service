package kr.hanhyur.productorderservice.payment;

import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGatewayImpl implements PaymentGateway {
    @Override
    public void excute(final int totalPrice, final String cardNumber) {
        System.out.println("Payment completed");
    }
}
