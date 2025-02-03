package co.simplon.converter;

import co.simplon.dto.ShoppingCartDTO;
import co.simplon.entity.ShoppingCart;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class ShoppingCartConverter {

    // Convertit une Entité en DTO
    public ShoppingCartDTO toDTO(ShoppingCart shoppingCart) {
        if (shoppingCart == null) {
            return null;
        }

        return new ShoppingCartDTO(
            shoppingCart.getShoppingCartId(),
            shoppingCart.getProductQuantity(),
            shoppingCart.getProducts() != null ? 
                shoppingCart.getProducts().stream()
                    .map(product -> new ProductConverter().toDTO(product))
                    .toList() : 
                new ArrayList<>()
        );
    }

    // Convertit un DTO en Entité
    public ShoppingCart toEntity(ShoppingCartDTO dto) {
        if (dto == null) {
            return null;
        }
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setShoppingCartId(dto.getShoppingCartId());
        shoppingCart.setProductQuantity(dto.getProductQuantity());
        
        // Note: Vous devrez peut-être ajouter la logique pour récupérer les produits
        // à partir de leurs IDs si nécessaire, en fonction de votre logique métier.
        // shoppingCart.setProducts(retrieveProductsByIds(dto.getProducts()));

        return shoppingCart;
    }
}
