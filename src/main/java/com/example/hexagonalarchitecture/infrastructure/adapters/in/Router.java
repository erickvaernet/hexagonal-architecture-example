package com.example.hexagonalarchitecture.infrastructure.adapters.in;

import com.example.hexagonalarchitecture.infrastructure.adapters.in.controller.CreateProductHandler;
import com.example.hexagonalarchitecture.infrastructure.adapters.in.controller.DeleteProductHandler;
import com.example.hexagonalarchitecture.infrastructure.adapters.in.controller.FindAllProductsHandler;
import com.example.hexagonalarchitecture.infrastructure.adapters.in.controller.FindByIdProductsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Router {
    @Bean
    public RouterFunction<ServerResponse> findIdProductRoute(FindByIdProductsHandler handler) {
        return RouterFunctions.route()
                .GET("/products/{id}", request -> handler.findByIdProduct(request.pathVariable("id")))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> findAllProductRoute(FindAllProductsHandler handler) {
        return RouterFunctions.route()
                .GET("/products", request -> handler.findAllProducts())
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> createProductRoute(CreateProductHandler handler) {
        return RouterFunctions.route()
                .POST("/products", request -> handler.createProduct(request))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> deleteProductRoute(DeleteProductHandler handle) {
        return RouterFunctions.route()
                .DELETE("/products/{id}", request -> handle.deleteProduct(request.pathVariable("id")))
                .build();
    }
}
