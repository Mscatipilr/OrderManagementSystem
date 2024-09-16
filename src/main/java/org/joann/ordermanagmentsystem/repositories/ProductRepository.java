package org.joann.ordermanagmentsystem.repositories;

import org.joann.ordermanagmentsystem.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);  // Custom query method to find product by name
}
