package ch.csbe.productstore.resources.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/")
    public String getProducts(){
        return "getProducts";
    }
    @GetMapping("/{id}")
    public String getProduct( @PathVariable("id") Integer id ){
        //return productService.getById(id);
        return "";
    }
    @PostMapping("/")
    public String postProduct(@RequestBody Product product){
        return "productService";
    }
    @PutMapping("/{id}")
    public String putProduct( @PathVariable("id") int id ){
        return "putProduct "+id;
    }
    @DeleteMapping("/{id}")
    public String deleteProduct( @PathVariable("id") int id ){
        return "deleteProduct "+id;
    }

}
