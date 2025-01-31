package co.simplon.dto;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDTO {
    private Long shoppingCartId;
    private int productQuantity;
    private List<ProductDTO> products = new ArrayList<>();

    // Constructeurs
    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(Long shoppingCartId, int productQuantity, List<ProductDTO> products) {
        this.shoppingCartId = shoppingCartId;
        this.productQuantity = productQuantity;
        this.products = products;
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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
} 