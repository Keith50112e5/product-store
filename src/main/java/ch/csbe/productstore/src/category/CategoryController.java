package ch.csbe.productstore.src.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/")
    public List<Category> getCategories(){
        return categoryService.get();
    }
    @GetMapping("/{id}")
    public Category getCategory( @PathVariable("id") Integer id ){
        return categoryService.getById(id);
    }
    @PostMapping("/")
    public Category postCategory(@RequestBody Category category){
        return categoryService.create(category);
    }
    @PutMapping("/{id}")
    public Category putCategory(@PathVariable("id") Integer id, @RequestBody Category category){
        return categoryService.update(id,category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory( @PathVariable("id") Integer id ){
        categoryService.delete(id);
    }
}
