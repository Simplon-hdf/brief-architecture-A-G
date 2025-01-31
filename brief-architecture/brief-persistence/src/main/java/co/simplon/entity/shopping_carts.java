package co.simplon.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_carts")

public class shopping_carts {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "shopping_cart_id")
private Long shoppingCartId;

@Column(name = "product_quantity")
private int productQuantity;

public shopping_carts() {
}

// Constructeur avec arguments
public shopping_carts(int productQuantity) {
    this.productQuantity = productQuantity;
}


// Getters et Setters
public Long getShoppingCartId() {
    return shoppingCartId;
}

public void setShoppingCartId(Long shoppingCartId) {
    this.shoppingCartId = shoppingCartId;
}   

public int getProductQuantity() {
    return productQuantity;
}

public void setProductQuantity(int productQuantity) {
    this.productQuantity = productQuantity;
}


@Override
public String toString() {
    return "shopping_carts{" +
            "shoppingCartId=" + shoppingCartId +
            ", productQuantity=" + productQuantity +
            '}';
    }
}

