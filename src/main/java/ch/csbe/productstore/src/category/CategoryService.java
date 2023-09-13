package ch.csbe.productstore.src.category;

import ch.csbe.productstore.src.category.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<CategoryDetailDto> getById(Integer id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            return new ResponseEntity<>(new CategoryDetailDto(), HttpStatus.NOT_FOUND)
        }
        Category category = categoryOptional.get();
        return new ResponseEntity<>(categoryMapper.toDetailDto(category), HttpStatus.OK);
    }
    public CategoryDetailDto create(CategoryCreateDto categoryCreateDto) {
        Category category = categoryMapper.toEntity(categoryCreateDto);
        Category save = categoryRepository.save(category);
        return categoryMapper.toDetailDto(save);
    }
    public ResponseEntity<CategoryDetailDto> update(Integer id, CategoryUpdateDto categoryUpdateDto) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            return new ResponseEntity<>(new CategoryDetailDto(), HttpStatus.NOT_FOUND);
        }
        Category category = categoryOptional.get();
        categoryMapper.update(categoryUpdateDto, category);
        Category save = categoryRepository.save(category);
        return new ResponseEntity<>(categoryMapper.toDetailDto(save), HttpStatus.OK);
    }
    public ResponseEntity<Void> delete(Integer id) {
        if (categoryRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        categoryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
