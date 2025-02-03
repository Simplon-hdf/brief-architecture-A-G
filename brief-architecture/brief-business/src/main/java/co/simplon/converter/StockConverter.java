package co.simplon.converter;

import co.simplon.dto.StockDTO;
import co.simplon.entity.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockConverter {

    // Convertit une Entité en DTO
    public StockDTO toDTO(Stock stock) {
        if (stock == null) {
            return null;
        }

        return new StockDTO(
            stock.getStockId(),
            stock.getProductStock(),
            stock.getProduct() != null ? stock.getProduct().getProductId() : null
        );
    }

    // Convertit un DTO en Entité
    public Stock toEntity(StockDTO dto) {
        if (dto == null) {
            return null;
        }
        Stock stock = new Stock();
        stock.setStockId(dto.getStockId());
        stock.setProductStock(dto.getProductStock());
        
        // Note: Vous devrez peut-être ajouter la logique pour récupérer le produit
        // à partir de son ID si nécessaire, en fonction de votre logique métier.
        // stock.setProduct(retrieveProductById(dto.getProductId()));

        return stock;
    }
}
