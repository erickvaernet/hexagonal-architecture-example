package com.example.hexagonalarchitecture.infrastructure.adapters.out.external;

import com.example.hexagonalarchitecture.infrastructure.adapters.out.external.entities.ProductExt;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExternalGateway {

    Mono<ProductExt> save(ProductExt ProductExt);

    Flux<ProductExt> findAll();

    Mono<ProductExt> findById(Long id);


    Mono<Void> deleteById(Long id);
}
