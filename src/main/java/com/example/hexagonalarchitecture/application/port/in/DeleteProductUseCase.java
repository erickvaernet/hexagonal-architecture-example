package com.example.hexagonalarchitecture.application.port.in;

import reactor.core.publisher.Mono;

public interface DeleteProductUseCase {

    Mono<Void> execute(Long id);
}
