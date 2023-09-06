package ch.csbe.productstore.src.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getByCategoryId(Integer id) {
        return productRepository.findProductsByCategory_Id(id);
    }
    public List<Product> get() {
        return productRepository.findAll();
    }
    public Product getById(Integer id) {
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
    }
    public Product create(Product product) {
        return productRepository.save(product);
    }
    public Product update(Integer id, Product productNew){
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        product.setProduct(productNew);
        return productRepository.save(product);
    }
    public void deleteById(Integer id){
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        productRepository.delete(product);
    }
}
