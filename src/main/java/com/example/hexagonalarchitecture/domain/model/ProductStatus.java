package com.example.hexagonalarchitecture.domain.model;

import java.util.Arrays;

public enum ProductStatus {
    AVAILABLE, UNAVAILABLE;

    public static ProductStatus getValue(String name) {
        return Arrays.stream(ProductStatus.values())
                .filter(status -> status.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Status not found"));
    }
}
