package ch.csbe.productstore.src.category;

import java.util.List;

public interface CategoryServiceInterface {
    List<Category> get();
    Category getById(Integer id);
    Category create(Category category);
    Category update(Integer id, Category categoryNew);
    void delete(Integer id);
}
