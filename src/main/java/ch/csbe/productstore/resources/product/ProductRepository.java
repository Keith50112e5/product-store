package ch.csbe.productstore.resources.product;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductByName(String name);
    List<Product> findProductsByCategoryIsNotNull();
}
