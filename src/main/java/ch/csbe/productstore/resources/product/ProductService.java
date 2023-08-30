package ch.csbe.productstore.resources.product;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> get() {
        return productRepository.findAll();
    }
    public Product getById(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            return productOptional.get();
        }
        return new Product();
    }
    public Product create(Product product) {
        return productRepository.save(product);
    }
    public Product update(Integer id, Product product){
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            Product existingProduct = productOptional.get();
            existingProduct.setProduct(product);
            return productRepository.save(existingProduct);
        }
        return new Product();
    }
    public Void deleteById(Integer id){
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
        }
        return null;
    }
}
