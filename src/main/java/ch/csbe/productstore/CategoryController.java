package ch.csbe.productstore;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @GetMapping("/{id}/products")
    public String getCategoryProducts( @PathVariable("id") int id ){
        return "getCategoryProducts "+id;
    }
    @GetMapping("/")
    public String getCategories(){
        return "getCategories";
    }
    @GetMapping("/{id}")
    public String getCategory( @PathVariable("id") int id ){
        return "getCategory "+id;
    }
    @PostMapping("/")
    public String postCategory(){
        return "postCategory";
    }
    @PutMapping("/{id}")
    public String putCategory( @PathVariable("id") int id ){
        return "putCategory "+id;
    }
    @DeleteMapping("/{id}")
    public String deleteCategory( @PathVariable("id") int id ){
        return "deleteCategory "+id;
    }
}
