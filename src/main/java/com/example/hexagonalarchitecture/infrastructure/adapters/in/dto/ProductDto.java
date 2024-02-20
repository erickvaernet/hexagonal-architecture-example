package com.example.hexagonalarchitecture.infrastructure.adapters.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductDto {
    @JsonProperty( access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = false,defaultValue = "AVAILABLE")
    private String status;
    @JsonProperty(required = false,defaultValue = "100")
    private Integer quantity;
    @JsonProperty(required = true)
    private Double price;

}
