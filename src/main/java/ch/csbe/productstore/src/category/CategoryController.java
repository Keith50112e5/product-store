package ch.csbe.productstore.src.category;

import ch.csbe.productstore.src.category.dto.CategoryCreateDto;
import ch.csbe.productstore.src.category.dto.CategoryDetailDto;
import ch.csbe.productstore.src.category.dto.CategoryShowDto;
import ch.csbe.productstore.src.category.dto.CategoryUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping()
    public List<CategoryShowDto> getCategories(){
        return categoryService.get();
    }
    @GetMapping("/{id}")
    public CategoryDetailDto getCategory(@PathVariable("id") Integer id ){
        return categoryService.getById(id);
    }
    @PostMapping()
    public CategoryDetailDto postCategory(@RequestBody CategoryCreateDto categoryCreateDto){
        return categoryService.create(categoryCreateDto);
    }
    @PutMapping("/{id}")
    public CategoryDetailDto putCategory(@PathVariable("id") Integer id, @RequestBody CategoryUpdateDto categoryUpdateDto){
        return categoryService.update(id,categoryUpdateDto);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory( @PathVariable("id") Integer id ){
        categoryService.delete(id);
    }
}
