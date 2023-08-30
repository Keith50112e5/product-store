package ch.csbe.productstore.resources.category;

import ch.csbe.productstore.resources.product.Product;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "tinyint")
    private Integer active;

    @Column(columnDefinition = "varchar(255)")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> product;
}
