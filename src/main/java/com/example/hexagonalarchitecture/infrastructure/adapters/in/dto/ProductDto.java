package com.example.hexagonalarchitecture.infrastructure.adapters.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductDto {
    @JsonProperty(access = READ_ONLY)
    private Long id;
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(access = READ_ONLY)
    private String status;
    @JsonProperty(required = true)
    private Integer quantity;
    @JsonProperty(required = true)
    private Double price;

}
