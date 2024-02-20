package com.example.hexagonalarchitecture.infrastructure.adapters.out.database.relational;

import com.example.hexagonalarchitecture.infrastructure.adapters.out.database.relational.tables.ProductStatusDb;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProductStatusR2dbcDao extends R2dbcRepository<ProductStatusDb, Integer> {

    Mono<ProductStatusDb> findByName(String name);
}
