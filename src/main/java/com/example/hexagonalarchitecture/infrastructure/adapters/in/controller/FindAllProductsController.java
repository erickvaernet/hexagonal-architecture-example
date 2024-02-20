package com.example.hexagonalarchitecture.infrastructure.adapters.in.controller;

import com.example.hexagonalarchitecture.application.port.in.FindAllProductsUseCase;
import com.example.hexagonalarchitecture.infrastructure.adapters.in.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class FindAllProductsController {

    private final FindAllProductsUseCase findAllProductsUseCase;



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ServerResponse> findAllProducts() {
        return findAllProductsUseCase.execute()
                .map(product-> ProductDto.builder().id(product.getId()).name(product.getName()).price(product.getPrice())
                        .status(product.getStatus().name()).build())
                .collectList()
                .flatMap(products -> ServerResponse.ok().body(products, ProductDto.class));
    }
}
