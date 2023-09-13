package ch.csbe.productstore.src.product;

import ch.csbe.productstore.src.product.dto.ProductCreateDto;
import ch.csbe.productstore.src.product.dto.ProductDetailDto;
import ch.csbe.productstore.src.product.dto.ProductShowDto;
import ch.csbe.productstore.src.product.dto.ProductUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductServiceInterface {
    List<ProductShowDto> getByCategoryId(Integer id);
    List<ProductShowDto> get();
    ResponseEntity<ProductDetailDto> getById(Integer id);
    ProductDetailDto create(ProductCreateDto productCreateDto);
    ResponseEntity<ProductDetailDto> update(Integer id, ProductUpdateDto productUpdateDto);
    ResponseEntity<Void> deleteById(Integer id);
}
