package kr.hanhyur.productorderservice.payment.domain;

import jakarta.persistence.*;
import kr.hanhyur.productorderservice.order.domain.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public
class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;

    private String cardNumber;

    public Payment(final Order order, final String cardNumber) {
        Assert.notNull(order, "Order is required");
        Assert.hasText(cardNumber, "Card Number is required");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }

}
