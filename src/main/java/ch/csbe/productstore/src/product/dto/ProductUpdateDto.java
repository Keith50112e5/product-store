package ch.csbe.productstore.src.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO für die Updateansicht eines Produkts")
public class ProductUpdateDto {
    private String sku;
    private Integer active;
    private String name;
    private String image;
    private String description;
    private Float price;
    private Integer stock;
}
