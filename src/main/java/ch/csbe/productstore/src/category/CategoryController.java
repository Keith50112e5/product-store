package ch.csbe.productstore.src.category;

import ch.csbe.productstore.src.category.dto.CategoryCreateDto;
import ch.csbe.productstore.src.category.dto.CategoryDetailDto;
import ch.csbe.productstore.src.category.dto.CategoryShowDto;
import ch.csbe.productstore.src.category.dto.CategoryUpdateDto;
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
@Tag(name="CategoryController", description="Controller für die Kategorien.")
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping()
    @Operation(summary = "Findet eine Liste aller Kategorien.", description = "Gibt die zu anzuzeigende Werte der Kategorien als Liste zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
    })
    public List<CategoryShowDto> getCategories(){
        return categoryService.get();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Findet eine Kategorie durch die ID.", description = "Gibt die Details mittels ID der Kategorien zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
    })
    public ResponseEntity<CategoryDetailDto> getCategory(
            @Parameter(description = "Die ID der Kategorie.")
            @PathVariable("id") Integer id ){
        return categoryService.getById(id);
    }
    @PostMapping()
    @Operation(summary = "Erstellt eine Kategorie.", description = "Gibt die Details mittels der Kategorie-Erstellwerte zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public CategoryDetailDto postCategory(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Die Kategorie-Erstellwerte.")
            @RequestBody CategoryCreateDto categoryCreateDto){
        return categoryService.create(categoryCreateDto);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Bearbeitet eine Kategorie durch die ID.", description = "Gibt die Details mittels ID und Bearbeitungswerte der Kategorien zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public ResponseEntity<CategoryDetailDto> putCategory(
            @Parameter(description = "Die ID der Kategorie.")
            @PathVariable("id") Integer id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Die Kategorie-Bearbeitungswerte.")
            @RequestBody CategoryUpdateDto categoryUpdateDto){
        return categoryService.update(id,categoryUpdateDto);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Löscht eine Kategorie durch die ID.", description = "Gibt ein OK mittels ID zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public ResponseEntity<Void> deleteCategory(
            @Parameter(description = "Die ID der Kategorie.")
            @PathVariable("id") Integer id ){
        return categoryService.delete(id);
    }
}
