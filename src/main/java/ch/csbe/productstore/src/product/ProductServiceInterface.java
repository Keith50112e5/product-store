package ch.csbe.productstore.src.product;

import ch.csbe.productstore.src.product.dto.ProductCreateDto;
import ch.csbe.productstore.src.product.dto.ProductDetailDto;
import ch.csbe.productstore.src.product.dto.ProductShowDto;
import ch.csbe.productstore.src.product.dto.ProductUpdateDto;

import java.util.List;

public interface ProductServiceInterface {
    List<ProductShowDto> getByCategoryId(Integer id);
    List<ProductShowDto> get();
    ProductDetailDto getById(Integer id);
    ProductDetailDto create(ProductCreateDto productCreateDto);
    ProductDetailDto update(Integer id, ProductUpdateDto productUpdateDto);
    void deleteById(Integer id);
}
