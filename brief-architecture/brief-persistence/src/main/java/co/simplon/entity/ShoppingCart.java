package co.simplon.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "shopping_cart_id")
private Long shoppingCartId;

@Column(name = "product_quantity")
private int productQuantity;

@ManyToMany
@JoinTable(name = "shopping_cart_products", joinColumns = @JoinColumn(name = "shopping_cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
private List<Product> products = new ArrayList<>();

// Constructeur par défaut
public ShoppingCart() {
}

// Constructeur avec arguments
public ShoppingCart(int productQuantity) {
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

public List<Product> getProducts() {
    return products;
}

public void setProducts(List<Product> products) {
    this.products = products;
}

@Override
public String toString() {
    return "ShoppingCart{" +
            "shoppingCartId=" + shoppingCartId +
            ", productQuantity=" + productQuantity +
            ", products=" + products.size() +
            '}';
    }
}

