package com.cts.easybuy.cart_order.service;


import com.cts.easybuy.cart_order.dto.CheckoutRequest;
import com.cts.easybuy.cart_order.dto.OrderCreateRequest;
import com.cts.easybuy.cart_order.dto.OrderResponse;
import com.cts.easybuy.cart_order.dto.ProductSnapshot;

import java.util.List;
import java.util.UUID;


public interface OrderService {


	//learning :
	ProductSnapshot createOrder(OrderCreateRequest orderCreateRequest) ;

	//for project
	OrderResponse checkout(String userId, CheckoutRequest request);

	OrderResponse getOrderById(Long orderId);

	OrderResponse getOrderByNumber(String orderNumber);

	List<OrderResponse> getOrdersByUserId(String userId);

	OrderResponse cancelOrder(Long orderId);

	void releaseReservedStock(UUID productId, Integer quantity);

	void updatePaymentStatus(Long orderId, String paymentStatus);
}
