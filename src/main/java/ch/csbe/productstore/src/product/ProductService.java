package ch.csbe.productstore.src.product;

import ch.csbe.productstore.src.product.dto.ProductCreateDto;
import ch.csbe.productstore.src.product.dto.ProductDetailDto;
import ch.csbe.productstore.src.product.dto.ProductShowDto;
import ch.csbe.productstore.src.product.dto.ProductUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;
    public List<ProductShowDto> getByCategoryId(Integer id) {
        // to be changed...
        return new ArrayList<ProductShowDto>();
    }
    public List<ProductShowDto> get() {
        List<Product> products = productRepository.findAll();
        List<ProductShowDto> productShowDtos = new ArrayList<>();
        for (Product product : products) {
            ProductShowDto productShowDto = productMapper.toShowDto(product);
            productShowDtos.add(productShowDto);
        }
        return productShowDtos;
    }
    public ProductDetailDto getById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        return productMapper.toDetailDto(product);
    }
    public ProductDetailDto create(ProductCreateDto productCreateDto) {
        Product product = productMapper.toEntity(productCreateDto);
        Product save = productRepository.save(product);
        return productMapper.toDetailDto(save);
    }
    public ProductDetailDto update(Integer id, ProductUpdateDto productUpdateDto){
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        productMapper.update(productUpdateDto, product);
        Product save = productRepository.save(product);
        return productMapper.toDetailDto(save);
    }
    public void deleteById(Integer id){
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        productRepository.delete(product);
    }
}
