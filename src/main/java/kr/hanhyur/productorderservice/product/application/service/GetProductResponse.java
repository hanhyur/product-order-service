package kr.hanhyur.productorderservice.product.application.service;

import kr.hanhyur.productorderservice.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

record GetProductResponse(
        long id,
        String productName,
        int price,
        DiscountPolicy discountPolicy
) {
    GetProductResponse {
        Assert.notNull(id, "Id is required");
        Assert.hasText(productName, "Product Name is required");
        Assert.notNull(discountPolicy, "DiscountPolicy is required");
    }
}
