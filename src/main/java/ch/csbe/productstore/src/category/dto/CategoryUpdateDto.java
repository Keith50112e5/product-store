package ch.csbe.productstore.src.category.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryUpdateDto {
    private Integer active;
    private String name;
}
