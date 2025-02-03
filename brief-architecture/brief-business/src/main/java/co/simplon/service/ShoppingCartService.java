package co.simplon.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.dto.ProductDTO;
import co.simplon.dto.ShoppingCartDTO;
import co.simplon.entity.Product;
import co.simplon.entity.ShoppingCart;
import co.simplon.repository.ProductRepository;
import co.simplon.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    // Créer un nouveau panier
    public ShoppingCartDTO createShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart(shoppingCartDTO.getProductQuantity());
        return convertToDTO(shoppingCartRepository.save(shoppingCart));
    }

    // Ajouter un produit au panier
    public ShoppingCartDTO addProductToCart(Long cartId, Long productId) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Panier non trouvé avec l'ID: " + cartId));
        
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'ID: " + productId));
        
        cart.getProducts().add(product);
        return convertToDTO(shoppingCartRepository.save(cart));
    }

    // Récupérer tous les paniers
    public List<ShoppingCartDTO> getAllShoppingCarts() {
        return shoppingCartRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    // Récupérer un panier par son ID
    public ShoppingCartDTO getShoppingCartById(Long id) {
        ShoppingCart cart = shoppingCartRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Panier non trouvé avec l'ID: " + id));
        return convertToDTO(cart);
    }

    // Supprimer un produit du panier
    public ShoppingCartDTO removeProductFromCart(Long cartId, Long productId) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Panier non trouvé avec l'ID: " + cartId));
        
        cart.getProducts().removeIf(product -> product.getProductId().equals(productId));
        return convertToDTO(shoppingCartRepository.save(cart));
    }

    // Supprimer un panier
    public void deleteShoppingCart(Long id) {
        shoppingCartRepository.deleteById(id);
    }

    // Méthode utilitaire pour convertir ShoppingCart en ShoppingCartDTO
    private ShoppingCartDTO convertToDTO(ShoppingCart cart) {
        List<ProductDTO> productDTOs = cart.getProducts().stream()
            .map(product -> new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice(),
                product.getStock() != null ? product.getStock().getProductStock() : 0))
            .collect(Collectors.toList());

        return new ShoppingCartDTO(
            cart.getShoppingCartId(),
            cart.getProductQuantity(),
            productDTOs
        );
    }
} 