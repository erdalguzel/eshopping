package dev.springboot.eshopping.repository;

import dev.springboot.eshopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
