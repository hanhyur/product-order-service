package kr.hanhyur.productorderservice.product;

import org.springframework.util.Assert;

record GetProductResponse(
        long id,
        String name,
        int price,
        DiscountPolicy discountPolicy
) {
    GetProductResponse {
        Assert.notNull(id, "Id is required");
        Assert.hasText(name, "Name is required");
        Assert.notNull(discountPolicy, "DiscountPolicy is required");

    }
}
