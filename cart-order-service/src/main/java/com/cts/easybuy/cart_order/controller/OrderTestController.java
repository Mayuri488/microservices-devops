package com.cts.easybuy.cart_order.controller;

import com.cts.easybuy.cart_order.dto.OrderCreateRequest;
import com.cts.easybuy.cart_order.dto.ProductSnapshot;
import com.cts.easybuy.cart_order.service.OrderService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test/orders")
@RequiredArgsConstructor
public class OrderTestController {

    private Logger logger = LoggerFactory.getLogger(OrderTestController.class);
    private final OrderService orderService;

    //array product ids:
    @PostMapping
    @RateLimiter(name="createOrderRateLimiter",fallbackMethod = "createOrderRateLimiterFallback")
    public ResponseEntity<ProductSnapshot> createOrder(@RequestBody OrderCreateRequest request) {

//        logger.info("Retrying.....");
        logger.info("order created request  received {}", request);

        //Manually throwing exception....
        //automatically

//        if (2 < 5) {
//            throw new NullPointerException("Request Failed");
//        }

//        return ResponseEntity.ok("order created");

        //order place logic
        return ResponseEntity.ok(orderService.createOrder(request));

    }

    public ResponseEntity<ProductSnapshot> createOrderRateLimiterFallback(OrderCreateRequest request, Throwable t) {
        logger.info("Rate limiter fallback triggered: {}", t.getMessage());
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
