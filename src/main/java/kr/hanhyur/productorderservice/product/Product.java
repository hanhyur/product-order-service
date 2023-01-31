package kr.hanhyur.productorderservice.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int price;
    private DiscountPolicy discountPolicy;

    public Product(final String productName, final int price, final DiscountPolicy discountPolicy) {
        Assert.hasText(productName, "Product Name is required");
        Assert.isTrue(price > 0, "Price must be bigger than 0");
        Assert.notNull(discountPolicy, "DiscountPolicy is required");

        this.productName = productName;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }
//
//    public void assignId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
}
