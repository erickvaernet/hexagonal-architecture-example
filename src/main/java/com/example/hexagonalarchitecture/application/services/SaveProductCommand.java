package com.example.hexagonalarchitecture.application.services;

import com.example.hexagonalarchitecture.application.port.in.CreateProductUseCase;
import com.example.hexagonalarchitecture.domain.model.Product;
import com.example.hexagonalarchitecture.domain.ports.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.example.hexagonalarchitecture.domain.model.ProductStatus.AVAILABLE;
import static com.example.hexagonalarchitecture.domain.model.ProductStatus.UNAVAILABLE;

@Service
@RequiredArgsConstructor
public class SaveProductCommand implements CreateProductUseCase {
    private final ProductRepository productRepository;

    @Override
    public Mono<Product> execute(Product product) {
        var prod = product.getQuantity() !=null && product.getQuantity() > 0 ?
                product.toBuilder().status(AVAILABLE).build()
                : product.toBuilder().status(UNAVAILABLE).build();
        return productRepository.save(prod);
    }
}
