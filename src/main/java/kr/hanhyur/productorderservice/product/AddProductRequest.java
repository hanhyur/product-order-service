package kr.hanhyur.productorderservice.product;

import org.springframework.util.Assert;

record AddProductRequest(String productName, int price, DiscountPolicy discountPolicy) {
    AddProductRequest {
        Assert.hasText(productName, "Product Name is required");
        Assert.isTrue(price > 0, "Price must be bigger than 0");
        Assert.notNull(discountPolicy, "DiscountPolicy is required");
    }

}
