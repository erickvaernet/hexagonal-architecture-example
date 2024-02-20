package com.example.hexagonalarchitecture.infrastructure.adapters.in.controller;

import com.example.hexagonalarchitecture.application.port.in.DeleteProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class DeleteProductController {

    private final DeleteProductUseCase deleteProductUseCase;


    @DeleteMapping( value = "/{id}" )
    public Mono<ServerResponse> deleteProduct(@PathVariable String id) {
        return ServerResponse.ok().build(deleteProductUseCase.execute(Long.valueOf(id)));
    }

}
