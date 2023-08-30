package ch.csbe.productstore;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    @GetMapping("/")
    public String getProducts(){
        return "getProducts";
    }
    @GetMapping("/{id}")
    public String getProduct( @PathVariable("id") int id ){
        return "getProduct "+id;
    }
    @PostMapping("/")
    public String postProduct(){
        return "postProduct";
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
