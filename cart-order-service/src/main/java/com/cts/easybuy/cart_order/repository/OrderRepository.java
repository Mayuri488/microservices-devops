package com.cts.easybuy.cart_order.repository;

import com.cts.easybuy.cart_order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByUserIdOrderByCreatedAtDesc(String userId);

	Optional<Order> findByOrderNumber(String orderNumber);
}
