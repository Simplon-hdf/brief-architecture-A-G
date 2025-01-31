package co.simplon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
} 