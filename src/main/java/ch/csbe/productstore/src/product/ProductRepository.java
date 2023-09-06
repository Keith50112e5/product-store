package ch.csbe.productstore.src.product;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductByName(String name);
    List<Product> findProductsByCategory_Id(Integer id);
}
