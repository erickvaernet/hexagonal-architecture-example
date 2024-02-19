package com.example.hexagonalarchitecture.infrastructure.outbound.database.relational;

import com.example.hexagonalarchitecture.infrastructure.outbound.database.relational.tables.ProductDb;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductR2dbcDao extends R2dbcRepository<ProductDb, Long> {
}
