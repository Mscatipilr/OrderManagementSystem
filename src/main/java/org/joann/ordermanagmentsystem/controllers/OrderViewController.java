package org.joann.ordermanagmentsystem.controllers;

import org.joann.ordermanagmentsystem.dto.OrderRequest;
import org.joann.ordermanagmentsystem.entities.Orders;
import org.joann.ordermanagmentsystem.entities.Product;
import org.joann.ordermanagmentsystem.services.OrderService;
import org.joann.ordermanagmentsystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderViewController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    // Display the list of orders
    @GetMapping("/orders/view")
    public String getOrders(Model model) {
        List<Orders> ordersList = orderService.getAllOrders();
        model.addAttribute("orders", ordersList);  // Add orders list to the model
        return "orders";  // Render orders.html
    }

    // Handle form submission to add a new order
    @PostMapping("/orders/view/add")
    public String addOrder(@ModelAttribute OrderRequest orderRequest) {
        // Find products by name
        List<Product> products = orderRequest.getProductNames().stream()
                .map(productService::findByName)
                .collect(Collectors.toList());

        // Create new order
        Orders order = new Orders();
        order.setProducts(products);
        order.setTotalPrice(orderRequest.getTotalPrice());

        // Save the order
        orderService.createOrder(order);

        return "redirect:/orders/view";  // Redirect to orders list after saving
    }
}
