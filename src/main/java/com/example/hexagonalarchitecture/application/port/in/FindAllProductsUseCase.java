package com.example.hexagonalarchitecture.application.port.in;

import com.example.hexagonalarchitecture.domain.model.Product;
import reactor.core.publisher.Flux;

public interface FindAllProductsUseCase {

    Flux<Product> execute();
}
