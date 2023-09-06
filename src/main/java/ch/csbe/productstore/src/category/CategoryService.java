package ch.csbe.productstore.src.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceInterface {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> get() {return categoryRepository.findAll();}
    public Category getById(Integer id) {
         return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
    }
    public Category create(Category category) {
        return categoryRepository.save(category);
    }
    public Category update(Integer id, Category categoryNew) {
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        category.setCategory(categoryNew);
        return categoryRepository.save(category);
    }
    public void delete(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        categoryRepository.delete(category);
    }
}
