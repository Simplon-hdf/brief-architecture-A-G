package co.simplon.dto;

public class StockDTO {
    private Long stockId;
    private int productStock;
    private Long productId;

    // Constructeurs
    public StockDTO() {
    }

    public StockDTO(Long stockId, int productStock, Long productId) {
        this.stockId = stockId;
        this.productStock = productStock;
        this.productId = productId;
    }

    // Getters et Setters
    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
} 