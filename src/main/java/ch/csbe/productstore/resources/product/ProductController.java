package ch.csbe.productstore.resources.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/")
    public List<Product> getProducts(){
        return productService.get();
    }
    @GetMapping("/{id}")
    public Product getProduct( @PathVariable("id") Integer id ){
        return productService.getById(id);
    }
    @PostMapping("/")
    public Product postProduct(@RequestBody Product product){
        return productService.create(product);
    }
    @PutMapping("/{id}")
    public Product putProduct( @PathVariable("id") Integer id, @RequestBody Product product ){
        return productService.update(id, product);
    }
    @DeleteMapping("/{id}")
    public Void deleteProduct( @PathVariable("id") Integer id ){
        return productService.deleteById(id);
    }

}
