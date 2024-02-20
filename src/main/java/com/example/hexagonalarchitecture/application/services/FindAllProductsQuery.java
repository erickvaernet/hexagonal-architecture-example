package com.example.hexagonalarchitecture.application.services;

import com.example.hexagonalarchitecture.application.port.in.FindAllProductsUseCase;
import com.example.hexagonalarchitecture.domain.model.Product;
import com.example.hexagonalarchitecture.domain.ports.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllProductsQuery implements FindAllProductsUseCase {
    private final ProductRepository productRepository;

    @Override
    public Flux<Product> execute() {
        return null;
    }
}
