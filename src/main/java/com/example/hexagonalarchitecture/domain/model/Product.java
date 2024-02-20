package com.example.hexagonalarchitecture.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {
    private Long id;
    private String name;
    private ProductStatus status;
    private Integer quantity;
    private Double price;

}
