package com.cts.easybuy.cart_order.client;

import com.cts.easybuy.cart_order.config.ProductClientFallback;
import com.cts.easybuy.cart_order.dto.ProductSnapshot;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "${PRODUCT_SERVICE_NAME}",url = "${PRODUCT_SERVICE_URL:}",fallback = ProductClientFallback.class)
public interface ProductClient {
	@GetMapping("/api/products/{productId}")
    ProductSnapshot getProductById(@PathVariable("productId") UUID productId);
}
