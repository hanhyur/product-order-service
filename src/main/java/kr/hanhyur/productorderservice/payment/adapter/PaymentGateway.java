package kr.hanhyur.productorderservice.payment.adapter;

/**
 * 실제 서비스에서는 PG사 연동 등을 통한 결제 API 호출
 */
interface PaymentGateway {
    void excute(int totalPrice, String cardNumber);

}
