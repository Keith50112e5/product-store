package ch.csbe.productstore.resources.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @GetMapping("/{id}/products")
    public String getCategoryProducts( @PathVariable("id") Integer id ){
        return "getCategoryProducts "+id;
    }
    @GetMapping("/")
    public List<String> getCategories(){
        return new ArrayList<>();
    }
    @GetMapping("/{id}")
    public String getCategory( @PathVariable("id") Integer id ){
        return "getCategory "+id;
    }
    @PostMapping("/")
    public String postCategory(){
        return "postCategory";
    }
    @PutMapping("/{id}")
    public String putCategory( @PathVariable("id") Integer id ){
        return "putCategory "+id;
    }
    @DeleteMapping("/{id}")
    public String deleteCategory( @PathVariable("id") Integer id ){
        return "deleteCategory "+id;
    }
}
