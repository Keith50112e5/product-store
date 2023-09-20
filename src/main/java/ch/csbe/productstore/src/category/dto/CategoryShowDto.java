package ch.csbe.productstore.src.category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO für die Anzeigeansicht einer Kategorie")
public class CategoryShowDto {
    private Boolean active;
    private String name;
}
