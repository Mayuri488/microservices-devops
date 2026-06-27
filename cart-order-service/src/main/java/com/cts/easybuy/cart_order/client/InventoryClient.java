package com.cts.easybuy.cart_order.client;

import com.cts.easybuy.cart_order.dto.InventorySnapshot;
import com.cts.easybuy.cart_order.dto.ReleaseStockRequest;
import com.cts.easybuy.cart_order.dto.ReserveStockRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;


@FeignClient(name = "${INVENTORY_SERVICE_NAME}",url = "${INVENTORY_SERVICE_URL:}")
public interface InventoryClient {

	@GetMapping("/api/inventories/product/{productId}")
	InventorySnapshot getInventoryByProductId(@PathVariable("productId") UUID productId);

	@PostMapping("/api/inventories/product/{productId}/reserve")
	InventorySnapshot reserveByProductId(@PathVariable("productId") UUID productId, @RequestBody ReserveStockRequest request);

	@PostMapping("/api/inventories/product/{productId}/release")
	InventorySnapshot releaseByProductId(@PathVariable("productId") UUID productId, @RequestBody ReleaseStockRequest request);
}
