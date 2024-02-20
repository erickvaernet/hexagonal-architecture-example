package com.example.hexagonalarchitecture.application.services;

import com.example.hexagonalarchitecture.application.port.in.CreateProductUseCase;
import com.example.hexagonalarchitecture.domain.model.Product;
import com.example.hexagonalarchitecture.domain.ports.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SaveProductCommand implements CreateProductUseCase {
    private final ProductRepository productRepository;

    @Override
    public Mono<Product> execute(Product product) {
        return null;
    }
}
