package com.example.hexagonalarchitecture.infrastructure.outbound.database.relational.tables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("products")
public class ProductDb {

    @Id
    private Long id;
    private String name;
    private Integer statusId;
    private Double price;

}
