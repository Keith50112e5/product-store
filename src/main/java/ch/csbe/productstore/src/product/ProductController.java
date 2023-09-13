package ch.csbe.productstore.src.product;

import ch.csbe.productstore.src.product.dto.ProductCreateDto;
import ch.csbe.productstore.src.product.dto.ProductDetailDto;
import ch.csbe.productstore.src.product.dto.ProductShowDto;
import ch.csbe.productstore.src.product.dto.ProductUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/category/{id}")
    public List<ProductShowDto> getCategoryProducts( @PathVariable("id") Integer id ){
        return productService.getByCategoryId(id);
    }
    @GetMapping()
    public List<ProductShowDto> getProducts(){
        return productService.get();
    }
    @GetMapping("/{id}")
    public ProductDetailDto getProduct(@PathVariable("id") Integer id ){
        return productService.getById(id);
    }
    @PostMapping()
    public ProductDetailDto postProduct(@RequestBody ProductCreateDto productCreateDto){
        return productService.create(productCreateDto);
    }
    @PutMapping("/{id}")
    public ProductDetailDto putProduct(@PathVariable("id")Integer id,@RequestBody ProductUpdateDto productUpdateDto){
        return productService.update(id,productUpdateDto);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct( @PathVariable("id") Integer id ){
        productService.deleteById(id);
    }

}
