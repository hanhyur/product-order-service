package kr.hanhyur.productorderservice.payment.adapter;


import kr.hanhyur.productorderservice.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentRepository extends JpaRepository<Payment, Long> {
//    private Map<Long, Payment> persistance = new HashMap<>();
//    private Long sequence = 0L;
//
//    public void save(Payment payment) {
//        payment.assignId(++sequence);
//        persistance.put(payment.getId(), payment);
//    }
}
