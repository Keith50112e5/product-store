package ch.csbe.productstore.src.category;

import ch.csbe.productstore.src.category.dto.CategoryCreateDto;
import ch.csbe.productstore.src.category.dto.CategoryDetailDto;
import ch.csbe.productstore.src.category.dto.CategoryShowDto;
import ch.csbe.productstore.src.category.dto.CategoryUpdateDto;

import java.util.List;

public interface CategoryServiceInterface {
    List<CategoryShowDto> get();
    CategoryDetailDto getById(Integer id);
    CategoryDetailDto create(CategoryCreateDto category);
    CategoryDetailDto update(Integer id, CategoryUpdateDto categoryNew);
    void delete(Integer id);
}
