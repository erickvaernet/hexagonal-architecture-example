package com.example.hexagonalarchitecture.infrastructure.adapters.in.controller;

import com.example.hexagonalarchitecture.application.port.in.FindProductByIdUseCase;
import com.example.hexagonalarchitecture.infrastructure.adapters.in.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindByIdProductsHandler {

    private final FindProductByIdUseCase findProductByIdUseCase;


    public Mono<ServerResponse> findByIdProduct( @PathVariable String id) {
        return findProductByIdUseCase.execute(Long.valueOf(id))
                .map(product-> ProductDto.builder().id(product.getId()).name(product.getName()).price(product.getPrice())
                        .status(product.getStatus().name()).quantity(product.getQuantity()).build())
                .flatMap(productDto -> ServerResponse.ok().bodyValue(productDto));
    }
}
