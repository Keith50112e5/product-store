package ch.csbe.productstore.src.product;

import ch.csbe.productstore.src.product.dto.ProductCreateDto;
import ch.csbe.productstore.src.product.dto.ProductDetailDto;
import ch.csbe.productstore.src.product.dto.ProductShowDto;
import ch.csbe.productstore.src.product.dto.ProductUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
  componentModel = "spring"
)
public abstract class ProductMapper {
    public  abstract Product toEntity(ProductCreateDto productCreateDto);
    public abstract ProductShowDto toShowDto(Product product);
    public abstract ProductDetailDto toDetailDto(Product product);
    public abstract void update(ProductUpdateDto productUpdateDto, @MappingTarget Product product);
}
