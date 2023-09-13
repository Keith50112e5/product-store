package ch.csbe.productstore.src.category;

import ch.csbe.productstore.src.category.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
        componentModel = "spring"
)
public abstract class CategoryMapper {
    public  abstract Category toEntity(CategoryCreateDto productCreateDto);
    public abstract CategoryShowDto toShowDto(Category category);
    public abstract CategoryDetailDto toDetailDto(Category category);
    public abstract void update(CategoryUpdateDto productUpdateDto, @MappingTarget Category category);
}
