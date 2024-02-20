package com.example.hexagonalarchitecture.application.services;

import com.example.hexagonalarchitecture.application.port.in.DeleteProductUseCase;
import com.example.hexagonalarchitecture.domain.ports.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteProductCommand implements DeleteProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public Mono<Void> execute(Long id) {
        return null;
    }
}
