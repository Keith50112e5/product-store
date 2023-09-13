package ch.csbe.productstore.src.product;

import ch.csbe.productstore.src.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(columnDefinition = "varchar(100)")
    private String sku;
    @Column(columnDefinition = "tinyint")
    private Integer active;
    @Column(columnDefinition = "varchar(500)")
    private String name;
    @Column(columnDefinition = "varchar(1000)")
    private String image;
    @Column(columnDefinition = "mediumtext")
    private String description;
    @Column(columnDefinition = "float")
    private Float price;
    @Column(columnDefinition = "int")
    private Integer stock;
    @ManyToOne()
    private Category category;
}
