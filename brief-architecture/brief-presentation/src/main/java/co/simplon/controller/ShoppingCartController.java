package co.simplon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.simplon.dto.ShoppingCartDTO;
import co.simplon.service.ShoppingCartService;

@RestController
@RequestMapping("/api/shopping-carts")
@CrossOrigin(origins = "*")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    // Créer un nouveau panier
    @PostMapping
    public ResponseEntity<ShoppingCartDTO> createShoppingCart(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        ShoppingCartDTO createdCart = shoppingCartService.createShoppingCart(shoppingCartDTO);
        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
    }

    // Ajouter un produit au panier
    @PostMapping("/{cartId}/products/{productId}")
    public ResponseEntity<ShoppingCartDTO> addProductToCart(
            @PathVariable Long cartId,
            @PathVariable Long productId) {
        try {
            ShoppingCartDTO updatedCart = shoppingCartService.addProductToCart(cartId, productId);
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Récupérer tous les paniers
    @GetMapping
    public ResponseEntity<List<ShoppingCartDTO>> getAllShoppingCarts() {
        List<ShoppingCartDTO> carts = shoppingCartService.getAllShoppingCarts();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    // Récupérer un panier par son ID
    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCartDTO> getShoppingCartById(@PathVariable Long id) {
        try {
            ShoppingCartDTO cart = shoppingCartService.getShoppingCartById(id);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un produit du panier
    @DeleteMapping("/{cartId}/products/{productId}")
    public ResponseEntity<ShoppingCartDTO> removeProductFromCart(
            @PathVariable Long cartId,
            @PathVariable Long productId) {
        try {
            ShoppingCartDTO updatedCart = shoppingCartService.removeProductFromCart(cartId, productId);
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un panier
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoppingCart(@PathVariable Long id) {
        try {
            shoppingCartService.deleteShoppingCart(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
} 