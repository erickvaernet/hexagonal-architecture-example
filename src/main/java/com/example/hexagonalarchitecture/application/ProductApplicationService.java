package com.example.hexagonalarchitecture.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductApplicationService {

    public Mono<Product> execute(Product product) {

        return Mono.just(product);
    }

}
