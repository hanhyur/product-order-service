package kr.hanhyur.productorderservice.product;

import org.springframework.util.Assert;

class Product {
    private Long id;
    private final String productName;
    private final int price;
    private final DiscountPolicy discountPolicy;

    public Product(final String productName, final int price, final DiscountPolicy discountPolicy) {
        Assert.hasText(productName, "Product Name is required");
        Assert.isTrue(price > 0, "Price must be bigger than 0");
        Assert.notNull(discountPolicy, "DiscountPolicy is required");

        this.productName = productName;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
