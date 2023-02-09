package kr.hanhyur.productorderservice.order;

import jakarta.persistence.*;
import kr.hanhyur.productorderservice.product.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;

    private int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        Assert.notNull(product, "Product is required");
        Assert.isTrue(quantity > 0, "Quantity must be bigger than 0");
    }

    public int getTotalPrice() {
        return product.getDiscountedPrice() * quantity;
    }

//    public void assignId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
}
