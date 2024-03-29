package ch.csbe.productstore.src.category;

import ch.csbe.productstore.src.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(columnDefinition = "tinyint")
    private Boolean active;
    @Column(columnDefinition = "varchar(255)")
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
