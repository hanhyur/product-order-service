package kr.hanhyur.productorderservice.product.adapter;

import kr.hanhyur.productorderservice.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    private Map<Long, Product> persistence = new HashMap<>();
//    private Long sequence = 0L;
//
//    public void save(Product product) {
//        product.assignId(++sequence);
//        persistence.put(product.getId(), product);
//    }
}
