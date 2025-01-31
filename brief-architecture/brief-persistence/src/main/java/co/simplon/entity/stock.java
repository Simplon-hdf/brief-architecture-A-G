package co.simplon.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stocks")

public class stock {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "stock_id")
private Long stockId;

@Column(name = "product_stock")
private int productStock;

public stocks() {
}

// Constructeur avec arguments
public stocks(int productStock) {
    this.productStock = productStock;
}


// Getters et Setters
public Long getstockId() {
    return stockId;
}

public void setstockId(Long stockId) {
    this.stockId = stockId;
}   

public int getproductStock() {
    return productStock;
}

public void setproductStock(int productStock) {
    this.productStock = productStock;
}


@Override
public String toString() {
    return "stock{" +
            "stockId=" + stockId +
            ", productStock=" + productStock +
            '}';
    }
}

