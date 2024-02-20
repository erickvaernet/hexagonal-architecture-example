package com.example.hexagonalarchitecture.application.port.in;

import com.example.hexagonalarchitecture.domain.model.Product;
import reactor.core.publisher.Mono;

public interface FindProductByIdUseCase {

    Mono<Product> execute(Long id);
}
