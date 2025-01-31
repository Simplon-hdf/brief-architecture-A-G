package co.simplon.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stock_id")
    private Long stockId;

    @Column(name = "product_stock", nullable = false)
    private int productStock;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Stock() {
    }

    // Constructeur avec arguments
    public Stock(int productStock, Product product) {
        this.productStock = productStock;
        this.product = product;
    }

    // Getters et Setters
    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }   

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", productStock=" + productStock +
                ", product=" + product.getProductId() +
                '}';
    }
}

