package kr.hanhyur.productorderservice.order;

import kr.hanhyur.productorderservice.product.Product;
import org.springframework.util.Assert;

class Order {
    private Long id;
    private final Product product;
    private final int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        Assert.notNull(product, "Product is required");
        Assert.isTrue(quantity > 0, "Quantity must be bigger than 0");
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
