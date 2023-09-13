package ch.csbe.productstore.src.category.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(description = "DTO für die Erstellansicht einer Kategorie")
public class CategoryCreateDto {
    public Integer active;
    public String name;
}
