package ch.csbe.productstore.resources.product;

import ch.csbe.productstore.resources.category.Category;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "varchar(100)")
    private String sku;

    @Column(columnDefinition = "tinyint")
    private Boolean active;

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

    public void setProduct(Product product) {
        this.sku = product.sku;
        this.active = product.active;
        this.name = product.name;
        this.image = product.image;
        this.description = product.description;
        this.price = product.price;
        this.stock = product.stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
