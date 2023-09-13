package ch.csbe.productstore.src.product;

import ch.csbe.productstore.src.product.dto.ProductCreateDto;
import ch.csbe.productstore.src.product.dto.ProductDetailDto;
import ch.csbe.productstore.src.product.dto.ProductShowDto;
import ch.csbe.productstore.src.product.dto.ProductUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@Tag(name="ProductController", description="Controller für die Produkte.")
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/category/{id}")
    @Operation(summary = "Findet eine Liste aller Produkte der Kategorie.", description = "Gibt die zu anzuzeigende Werte der Produkte der Kategorie als Liste zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
    })
    public List<ProductShowDto> getCategoryProducts(
            @Parameter(description = "Die ID des Produktes.")
            @PathVariable("id") Integer id ){
        return productService.getByCategoryId(id);
    }
    @GetMapping()
    @Operation(summary = "Findet eine Liste aller Produkte.", description = "Gibt die zu anzuzeigende Werte der Produkte der Kategorie als Liste zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
    })
    public List<ProductShowDto> getProducts(){
        return productService.get();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Findet ein Produkt durch die ID.", description = "Gibt die Details mittels ID des Produktes zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
    })
    public ResponseEntity<ProductDetailDto> getProduct(
            @Parameter(description = "Die ID des Produktes.")
            @PathVariable("id") Integer id ){
        return productService.getById(id);
    }
    @PostMapping()
    @Operation(summary = "Erstellt ein Produkt durch die ID.", description = "Gibt die Details mittels der Produkt-Erstellwerte zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public ProductDetailDto postProduct(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Die Produkt-Erstellwerte.")
            @RequestBody ProductCreateDto productCreateDto){
        return productService.create(productCreateDto);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Bearbeitet ein Produkt durch die ID.", description = "Gibt die Details mittels ID und Bearbeitungswerte des Produktes zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public ResponseEntity<ProductDetailDto> putProduct(
            @Parameter(description = "Die ID des Produktes.")
            @PathVariable("id")Integer id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Die Produkt-Bearbeitungswerte.")
            @RequestBody ProductUpdateDto productUpdateDto){
        return productService.update(id,productUpdateDto);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Löscht ein Produkt durch die ID.", description = "Gibt ein OK mittels ID zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "Die ID des Produktes.")
            @PathVariable("id") Integer id ){
        return productService.deleteById(id);
    }

}
