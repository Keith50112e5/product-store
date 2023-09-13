package ch.csbe.productstore.src.category;

import ch.csbe.productstore.src.category.dto.CategoryCreateDto;
import ch.csbe.productstore.src.category.dto.CategoryDetailDto;
import ch.csbe.productstore.src.category.dto.CategoryShowDto;
import ch.csbe.productstore.src.category.dto.CategoryUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryServiceInterface {
    List<CategoryShowDto> get();
    ResponseEntity<CategoryDetailDto> getById(Integer id);
    CategoryDetailDto create(CategoryCreateDto category);
    ResponseEntity<CategoryDetailDto> update(Integer id, CategoryUpdateDto categoryNew);
    ResponseEntity<Void> delete(Integer id);
}
