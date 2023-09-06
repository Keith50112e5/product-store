package ch.csbe.productstore.src.product;

import java.util.List;

public interface ProductServiceInterface {
    List<Product> getByCategoryId(Integer id);
    List<Product> get();
    Product getById(Integer id);
    Product create(Product product);
    Product update(Integer id, Product productNew);
    void deleteById(Integer id);
}
