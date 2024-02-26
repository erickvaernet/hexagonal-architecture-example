package com.example.hexagonalarchitecture.infrastructure.adapters.out.database.relational.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("product_statuses")
public class ProductStatusDb {
    @Id
    private Integer id;
    private String name;
}
