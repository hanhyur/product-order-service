package kr.hanhyur.productorderservice.product;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Long> {
//    private Map<Long, Product> persistence = new HashMap<>();
//    private Long sequence = 0L;
//
//    public void save(Product product) {
//        product.assignId(++sequence);
//        persistence.put(product.getId(), product);
//    }
}
