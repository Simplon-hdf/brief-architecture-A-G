package co.simplon.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.dto.ProductDTO;
import co.simplon.entity.Product;
import co.simplon.entity.Stock;
import co.simplon.repository.ProductRepository;
import co.simplon.repository.StockRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    // Créer un nouveau produit
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product(
            productDTO.getProductName(),
            productDTO.getProductDescription(),
            productDTO.getProductPrice()
        );
        
        Product savedProduct = productRepository.save(product);
        
        // Créer et sauvegarder le stock associé
        Stock stock = new Stock(productDTO.getStockQuantity(), savedProduct);
        stockRepository.save(stock);
        
        return convertToDTO(savedProduct, stock.getProductStock());
    }

    // Récupérer tous les produits
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
            .map(product -> convertToDTO(product, 
                product.getStock() != null ? product.getStock().getProductStock() : 0))
            .collect(Collectors.toList());
    }

    // Récupérer un produit par son ID
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'ID: " + id));
        
        return convertToDTO(product, 
            product.getStock() != null ? product.getStock().getProductStock() : 0);
    }

    // Mettre à jour un produit
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'ID: " + id));
        
        product.setProductName(productDTO.getProductName());
        product.setProductDescription(productDTO.getProductDescription());
        product.setProductPrice(productDTO.getProductPrice());
        
        Product updatedProduct = productRepository.save(product);
        
        // Mettre à jour le stock
        if (product.getStock() != null) {
            Stock stock = product.getStock();
            stock.setProductStock(productDTO.getStockQuantity());
            stockRepository.save(stock);
        }
        
        return convertToDTO(updatedProduct, productDTO.getStockQuantity());
    }

    // Supprimer un produit
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Méthode utilitaire pour convertir Product en ProductDTO
    private ProductDTO convertToDTO(Product product, int stockQuantity) {
        return new ProductDTO(
            product.getProductId(),
            product.getProductName(),
            product.getProductDescription(),
            product.getProductPrice(),
            stockQuantity
        );
    }
} 