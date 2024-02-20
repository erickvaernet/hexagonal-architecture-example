package com.example.hexagonalarchitecture.infrastructure.adapters.in.controller;

import com.example.hexagonalarchitecture.application.port.in.FindProductByIdUseCase;
import com.example.hexagonalarchitecture.infrastructure.adapters.in.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class FindByIdProductsController {

    private final FindProductByIdUseCase findProductByIdUseCase;



    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ServerResponse> findByIdProduct( @PathVariable String id) {
        return findProductByIdUseCase.execute(Long.valueOf(id))
                .map(product-> ProductDto.builder().id(product.getId()).name(product.getName()).price(product.getPrice())
                        .status(product.getStatus().name()).quantity(product.getQuantity()).build())
                .flatMap(productDto -> ServerResponse.ok().body(productDto, ProductDto.class));
    }
}
