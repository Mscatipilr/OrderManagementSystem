package org.joann.ordermanagmentsystem.services;

import org.joann.ordermanagmentsystem.entities.Product;
import org.joann.ordermanagmentsystem.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to find a product by name
    public Product findByName(String name) {
        return productRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Product not found: " + name));
    }
}
