package com.example.hexagonalarchitecture.infrastructure.outbound.external;

import com.example.hexagonalarchitecture.infrastructure.outbound.external.entities.ProductExt;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExternalGateway {

    Mono<ProductExt> save(ProductExt ProductExt);

    Flux<ProductExt> findAll();

    Mono<ProductExt> findById(Long id);


    Mono<Void> deleteById(Long id);
}
