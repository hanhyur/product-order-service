package kr.hanhyur.productorderservice.payment;

public class ConsolePaymentGatewayImpl implements PaymentGateway {
    @Override
    public void excute(final int totalPrice, final String cardNumber) {
        System.out.println("Payment completed");
    }
}
