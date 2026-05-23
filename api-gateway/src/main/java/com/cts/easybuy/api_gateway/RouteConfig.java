package com.cts.easybuy.api_gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {


    private final String productServiceId;
    private final String cartOrderServiceId;

    public RouteConfig(@Value("${product.service.id}") String productServiceId, @Value("${cartorder.service.id}") String cartOrderServiceId) {
        this.productServiceId = productServiceId;
        this.cartOrderServiceId = cartOrderServiceId;
    }

    @Bean
    public RouteLocator route(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-route", route ->
                        route

                                .path("/products/**")
                                .filters(f -> f
                                        .addRequestHeader("x-api-gateway", "value from api gateway")

                                                .
                                        rewritePath("/products/?(?<remaining>.*)", "/${remaining}"))
                                .uri(productServiceId))
                .route("cart-order-route", route ->
                        route.path("/cart-orders/**")
                                .filters(f -> f.rewritePath("/cart-orders/?(?<remaining>.*)", "/${remaining}"))
                                .uri(cartOrderServiceId)
                )


                .build();
    }



}
