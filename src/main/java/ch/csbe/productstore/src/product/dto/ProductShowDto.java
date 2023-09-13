package ch.csbe.productstore.src.product.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductShowDto {
    private String sku;
    private Integer active;
    private String name;
    private String image;
    private String description;
    private Float price;
    private Integer stock;
}
