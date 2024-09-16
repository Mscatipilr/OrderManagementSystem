package org.joann.ordermanagmentsystem.controllers;

import org.joann.ordermanagmentsystem.dto.OrderRequest;
import org.joann.ordermanagmentsystem.entities.Orders;
import org.joann.ordermanagmentsystem.entities.Product;
import org.joann.ordermanagmentsystem.services.OrderService;
import org.joann.ordermanagmentsystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;  // Service for looking up products

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody OrderRequest orderRequest) {
        // Retrieve the actual Product entities from the database based on product names
        List<Product> products = orderRequest.getProductNames().stream()
                .map(productService::findByName)  // Assuming productService has a method to find by name
                .collect(Collectors.toList());

        // Create the order
        Orders order = new Orders();
        order.setProducts(products);
        order.setTotalPrice(orderRequest.getTotalPrice());

        // Save the order
        Orders savedOrder = orderService.createOrder(order);

        return ResponseEntity.ok(savedOrder);
    }

    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders ordersDetails) {
        return orderService.updateOrder(id, ordersDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }
}
