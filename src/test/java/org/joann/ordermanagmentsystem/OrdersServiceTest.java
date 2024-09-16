package org.joann.ordermanagmentsystem;

import org.joann.ordermanagmentsystem.entities.Order;
import org.joann.ordermanagmentsystem.services.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        // Set products, totalPrice, etc.
        Order savedOrder = orderService.createOrder(order);
        assertNotNull(savedOrder.getId());
    }

    @Test
    public void testUpdateOrder() {
        Order order = new Order();
        Order savedOrder = orderService.createOrder(order);
        savedOrder.setTotalPrice(200.0);
        Order updatedOrder = orderService.updateOrder(savedOrder.getId(), savedOrder);
        assertEquals(200.0, updatedOrder.getTotalPrice());
    }

    @Test
    public void testDeleteOrder() {
        Order order = new Order();
        Order savedOrder = orderService.createOrder(order);
        orderService.deleteOrder(savedOrder.getId());
        assertThrows(RuntimeException.class, () -> orderService.updateOrder(savedOrder.getId(), savedOrder));
    }
}
