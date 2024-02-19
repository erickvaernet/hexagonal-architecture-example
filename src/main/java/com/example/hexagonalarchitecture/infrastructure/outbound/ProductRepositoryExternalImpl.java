package com.example.hexagonalarchitecture.infrastructure.outbound;

import com.example.hexagonalarchitecture.domain.model.Product;
import com.example.hexagonalarchitecture.domain.ports.repository.ProductRepository;
import com.example.hexagonalarchitecture.infrastructure.outbound.external.ExternalGateway;
import com.example.hexagonalarchitecture.infrastructure.outbound.external.entities.ProductExt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductRepositoryExternalImpl implements ProductRepository {

    private final ExternalGateway externalGateway;

    @Override
    public Mono<Product> save(Product product) {
        return externalGateway.save(ProductExt.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).build())
                .map( productExt -> product.toBuilder().name(productExt.getName()).price(productExt.getPrice()).build());
    }

    @Override
    public Flux<Product> findAll() {
        return externalGateway.findAll()
                .map(productExt -> Product.builder()
                    .id(productExt.getId())
                    .name(productExt.getName())
                    .price(productExt.getPrice())
                    .build()
                );
    }

    @Override
    public Mono<Product> findById(Long id) {
        return externalGateway.findById(id).map(productExt -> Product.builder()
                .id(productExt.getId())
                .name(productExt.getName())
                .price(productExt.getPrice())
                .build()
        );
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return externalGateway.deleteById(id);
    }
}
