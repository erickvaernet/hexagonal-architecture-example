package com.example.hexagonalarchitecture.infrastructure.outbound.database.relational.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("product_statuses")
public class ProductStatusDb {
    private Integer id;
    private String name;
}
