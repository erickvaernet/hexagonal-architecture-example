package com.example.hexagonalarchitecture.application.port.in;

import com.example.hexagonalarchitecture.domain.model.Product;
import reactor.core.publisher.Mono;

public interface CreateProductUseCase {

    Mono<Product> execute(Product product);
}
