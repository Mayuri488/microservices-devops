package com.cts.easybuy.cart_order.repository;

import com.cts.easybuy.cart_order.entity.Cart;
import com.cts.easybuy.cart_order.entity.CartStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

	Optional<Cart> findByUserIdAndStatus(String userId, CartStatus status);
}
