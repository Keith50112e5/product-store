package ch.csbe.productstore.src.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO für die Erstellansicht eines Produkts")
public class ProductShowDto {
    private String sku;
    private Boolean active;
    private String name;
    private String image;
    private String description;
    private Float price;
    private Integer stock;
}
