package org.joann.ordermanagmentsystem.repositories;

import org.joann.ordermanagmentsystem.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
