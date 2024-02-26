package com.example.hexagonalarchitecture.infrastructure.adapters.in.controller;

import com.example.hexagonalarchitecture.application.port.in.CreateProductUseCase;
import com.example.hexagonalarchitecture.domain.model.Product;
import com.example.hexagonalarchitecture.infrastructure.adapters.in.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static com.example.hexagonalarchitecture.domain.model.ProductStatus.getValue;

@Component
@RequiredArgsConstructor
public class CreateProductHandler {

    private final CreateProductUseCase createProductUseCase;

    public Mono<ServerResponse> createProduct(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(ProductDto.class)
                .flatMap(createProductRequest -> createProductUseCase.execute(Product.builder()
                        .name(createProductRequest.getName())
                        .price(createProductRequest.getPrice())
                        .status(createProductRequest.getStatus()!=null?getValue(createProductRequest.getStatus()):null)
                        .quantity(createProductRequest.getQuantity())
                        .build())
                )
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .status(product.getStatus().name())
                        .quantity(product.getQuantity())
                        .build()
                )
                .flatMap(productDto -> ServerResponse.status(HttpStatus.CREATED).bodyValue(productDto));
    }
}
