package co.simplon.entity;

import java.util.concurrent.atomic.LongAccumulator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long product_id;

    @Column(name="product_name", length=50, nullable=false)
    private String product_name;

    @Column(name="product_description", length=255, nullable=false)
    private String product_description;

    @Column(name="product_price", length=15, nullable=false)
    private double product_price;
    
    // Constructeur sans argument requis par JPA
    public Product() {
    }

    // Constructeur avec arguments
    public Product(String product_name, String product_description, double product_price) {
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
    }

    // Getters et Setters
    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_description='" + product_description + '\'' +
                ", product_price=" + product_price +
                '}';
    }
}