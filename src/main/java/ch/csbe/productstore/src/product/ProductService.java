package ch.csbe.productstore.src.product;

import ch.csbe.productstore.src.product.dto.ProductCreateDto;
import ch.csbe.productstore.src.product.dto.ProductDetailDto;
import ch.csbe.productstore.src.product.dto.ProductShowDto;
import ch.csbe.productstore.src.product.dto.ProductUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<ProductDetailDto> getById(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()){
            return new ResponseEntity<>(new ProductDetailDto(), HttpStatus.NOT_FOUND);
        }
        Product product = productOptional.get();
        return new ResponseEntity<>(productMapper.toDetailDto(product), HttpStatus.OK);
    }
    public ProductDetailDto create(ProductCreateDto productCreateDto) {
        Product product = productMapper.toEntity(productCreateDto);
        Product save = productRepository.save(product);
        return productMapper.toDetailDto(save);
    }
    public ResponseEntity<ProductDetailDto> update(Integer id, ProductUpdateDto productUpdateDto){
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            return new ResponseEntity<>(new ProductDetailDto(), HttpStatus.NOT_FOUND);
        }
        Product product = productOptional.get();
        productMapper.update(productUpdateDto, product);
        Product save = productRepository.save(product);
        return new ResponseEntity<>(productMapper.toDetailDto(save), HttpStatus.OK);
    }
    public ResponseEntity<Void> deleteById(Integer id){
        if(!productRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
