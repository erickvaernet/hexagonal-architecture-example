package com.example.hexagonalarchitecture.infrastructure.outbound.external;

import com.example.hexagonalarchitecture.domain.model.Product;
import com.example.hexagonalarchitecture.infrastructure.outbound.external.entities.ProductExt;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ExternalGatewayImpl implements ExternalGateway {

    private final WebClient externalWebClient;

    @Override
    public Mono<ProductExt> save(ProductExt ProductExt) {
        return externalWebClient.post().uri("/products").body(Mono.just(ProductExt), ProductExt.class)
                .retrieve().bodyToMono(ProductExt.class);
    }

    @Override
    public Flux<ProductExt> findAll() {
        return externalWebClient.get().uri("/products").retrieve().bodyToFlux(ProductExt.class);
    }

    @Override
    public Mono<ProductExt> findById(Long id) {
        return externalWebClient.get().uri("/products/{id}", id).retrieve().bodyToMono(ProductExt.class);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return externalWebClient.delete().uri("/products/{id}", id).retrieve().bodyToMono(Void.class);
    }
}
