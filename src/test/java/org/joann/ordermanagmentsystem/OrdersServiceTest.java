package org.joann.ordermanagmentsystem;

import org.joann.ordermanagmentsystem.entities.Orders;
import org.joann.ordermanagmentsystem.services.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrdersServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        Orders orders = new Orders();
        // Set products, totalPrice, etc.
        Orders savedOrders = orderService.createOrder(orders);
        assertNotNull(savedOrders.getId());
    }

    @Test
    public void testUpdateOrder() {
        Orders orders = new Orders();
        Orders savedOrders = orderService.createOrder(orders);
        savedOrders.setTotalPrice(200.0);
        Orders updatedOrders = orderService.updateOrder(savedOrders.getId(), savedOrders);
        assertEquals(200.0, updatedOrders.getTotalPrice());
    }

    @Test
    public void testDeleteOrder() {
        Orders orders = new Orders();
        Orders savedOrders = orderService.createOrder(orders);
        orderService.deleteOrder(savedOrders.getId());
        assertThrows(RuntimeException.class, () -> orderService.updateOrder(savedOrders.getId(), savedOrders));
    }
}
