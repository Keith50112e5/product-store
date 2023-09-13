package ch.csbe.productstore.src.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateDto {
    private String sku;
    private Integer active;
    private String name;
    private String image;
    private String description;
    private Float price;
    private Integer stock;
}
