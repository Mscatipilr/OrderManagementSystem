package org.joann.ordermanagmentsystem.services;

import org.joann.ordermanagmentsystem.entities.Orders;
import org.joann.ordermanagmentsystem.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Orders createOrder(Orders orders) {
        return orderRepository.save(orders);
    }

    public Orders updateOrder(Long id, Orders ordersDetails) {
        Orders orders = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orders.setProducts(ordersDetails.getProducts());
        orders.setTotalPrice(ordersDetails.getTotalPrice());
        return orderRepository.save(orders);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }
}
