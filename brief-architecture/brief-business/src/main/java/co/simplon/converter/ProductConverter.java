package co.simplon.converter;

import co.simplon.dto.ProductDTO;
import co.simplon.entity.Product;
import co.simplon.entity.Stock;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    // Convertit une Entité en DTO
    public ProductDTO toDTO(Product product) {
        if (product == null) {
            return null;
        }

       int stockQuantity = (product.getStock() != null) ? product.getStock().getProductStock() : 0;       

        return new ProductDTO(
            product.getProductId(),
            product.getProductName(),
            product.getProductDescription(),
            product.getProductPrice(),
            stockQuantity
        );
    }

    // Convertit un DTO en Entité
    public Product toEntity(ProductDTO dto) {
        if (dto == null) {
            return null;
        }
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setProductDescription(dto.getProductDescription());
        product.setProductPrice(dto.getProductPrice());
        
        Stock stock = new Stock();
        stock.setProductStock(dto.getStockQuantity());
        product.setStock(stock);

        return product;
    }
}
