package com.example.hexagonalarchitecture.domain.ports.out;

import com.example.hexagonalarchitecture.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {
    Mono<Product>save(Product product);
    Flux<Product> findAll();
    Mono<Product> findById(Long id);
    Mono<Void>deleteById(Long id);
}
