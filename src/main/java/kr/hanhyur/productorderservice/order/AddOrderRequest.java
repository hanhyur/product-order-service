package kr.hanhyur.productorderservice.order;

import org.springframework.util.Assert;

record AddOrderRequest(Long productId, int quantity) {
    AddOrderRequest {
        Assert.notNull(productId, "Product Id is required");
        Assert.isTrue(quantity > 0, "Quantity must be bigger than 0");
    }
}
