package com.example.hexagonalarchitecture.infrastructure.adapters.in.controller;

import com.example.hexagonalarchitecture.application.port.in.DeleteProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
@Component
@RequiredArgsConstructor
public class DeleteProductHandler {

    private final DeleteProductUseCase deleteProductUseCase;

    public Mono<ServerResponse> deleteProduct(@PathVariable String id) {
        return ServerResponse.ok().build(deleteProductUseCase.execute(Long.valueOf(id)));
    }

}
