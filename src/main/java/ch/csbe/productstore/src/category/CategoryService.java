package ch.csbe.productstore.src.category;

import ch.csbe.productstore.src.category.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceInterface {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryMapper categoryMapper;
    public List<CategoryShowDto> get() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryShowDto> categoryShowDtos = new ArrayList<>();
        for (Category category : categories) {
            CategoryShowDto categoryShowDto = categoryMapper.toShowDto(category);
            categoryShowDtos.add(categoryShowDto);
        }
        return categoryShowDtos;
    }
    public CategoryDetailDto getById(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
         return categoryMapper.toDetailDto(category);
    }
    public CategoryDetailDto create(CategoryCreateDto categoryCreateDto) {
        Category category = categoryMapper.toEntity(categoryCreateDto);
        Category save = categoryRepository.save(category);
        return categoryMapper.toDetailDto(save);
    }
    public CategoryDetailDto update(Integer id, CategoryUpdateDto categoryUpdateDto) {
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        categoryMapper.update(categoryUpdateDto, category);
        Category save = categoryRepository.save(category);
        return categoryMapper.toDetailDto(save);
    }
    public void delete(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        categoryRepository.delete(category);
    }
}
