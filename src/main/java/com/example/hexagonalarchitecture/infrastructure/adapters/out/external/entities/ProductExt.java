package com.example.hexagonalarchitecture.infrastructure.adapters.out.external.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductExt {

    private Long id;
    @JsonProperty("title")
    private String name;
    @JsonIgnore
    private String status;
    private Double price;


}
