package org.joann.ordermanagmentsystem.controllers;

import org.joann.ordermanagmentsystem.entities.Product;
import org.joann.ordermanagmentsystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // API: Create Product (REST)
    @PostMapping("/api")
    @ResponseBody
    public Product createProductApi(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // API: Update Product (REST)
    @PutMapping("/api/{id}")
    @ResponseBody
    public Product updateProductApi(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    // API: Delete Product (REST)
    @DeleteMapping("/api/{id}")
    @ResponseBody
    public void deleteProductApi(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // API: Get All Products (REST)
    @GetMapping("/api")
    @ResponseBody
    public List<Product> getAllProductsApi() {
        return productService.getAllProducts();
    }

    // Thymeleaf View: Show all products in a table
    @GetMapping
    public String getProductsView(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";  // Thymeleaf will render the products.html page
    }

    // Thymeleaf View: Add a product form submission
    @PostMapping
    public String addProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
        return "redirect:/products";  // Redirect to the product list after adding
    }
}
