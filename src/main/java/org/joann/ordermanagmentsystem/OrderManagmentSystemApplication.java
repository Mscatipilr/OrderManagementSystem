package org.joann.ordermanagmentsystem;

import org.joann.ordermanagmentsystem.entities.Product;
import org.joann.ordermanagmentsystem.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderManagmentSystemApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrderManagmentSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Add initial products to the database
        productRepository.save(new Product("Apple", 1.00));
        productRepository.save(new Product("Banana", 0.50));
        productRepository.save(new Product("Orange", 0.75));

        System.out.println("Products added to the database");
    }
}
