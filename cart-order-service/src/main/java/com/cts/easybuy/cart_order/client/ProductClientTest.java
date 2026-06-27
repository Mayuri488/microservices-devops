package com.cts.easybuy.cart_order.client;

import com.cts.easybuy.cart_order.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "course-service",url = "http://localhost:8081/api")
@FeignClient(name = "productClientTest")
public interface ProductClientTest {
    @GetMapping("/api/products/{productId}")
    ProductResponse getProductById(@PathVariable("productId") String productId);

//    @PostMapping
//    ProductResponse createProduct(@RequestBody ProductDto productDto);\


    //sare operations apis ki tarah bana sakte ho:

}
