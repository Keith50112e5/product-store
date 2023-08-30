package ch.csbe.productstore.resources.product;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProducts();
    Product findProductById(Integer Id);
    List<Product> findProductsByCategoryIsNotNull();

}
