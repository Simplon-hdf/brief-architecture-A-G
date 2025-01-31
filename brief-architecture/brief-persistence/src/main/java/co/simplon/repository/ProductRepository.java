package co.simplon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
} 