package com.example.hexagonalarchitecture.infrastructure.adapters.in.controller;

import com.example.hexagonalarchitecture.application.port.in.FindAllProductsUseCase;
import com.example.hexagonalarchitecture.infrastructure.adapters.in.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindAllProductsHandler {

    private final FindAllProductsUseCase findAllProductsUseCase;

    public Mono<ServerResponse> findAllProducts() {
        return findAllProductsUseCase.execute()
                .map(product-> ProductDto.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).quantity(product.getQuantity())
                        .status(product.getStatus().name()).build())
                .collectList()
                .flatMap(products -> ServerResponse.ok().bodyValue(products));
    }
}
